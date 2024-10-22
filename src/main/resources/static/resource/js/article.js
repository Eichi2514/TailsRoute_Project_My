$(document).ready(function () {
    function ArticleWrite__submit(form) {
        form.title.value = form.title.value.trim();

        if (form.title.value.length === 0) {
            alert('제목을 입력하세요');
            return false;
        }

        const editor = $(form).find('.toast-ui-editor').data('data-toast-editor');
        const markdown = editor.getMarkdown().trim();

        if (markdown.length === 0) {
            alert('내용을 입력하세요');
            return false;
        }

        $('#fileInput').attr('name', 'file__article__' + currentId +'__extra__Img__1');

        form.body.value = markdown;
        form.submit();
    }
});

function ArticleModify__submit(form) {
    // 제목 공백 제거
    form.title.value = $.trim(form.title.value);
    if (form.title.value.length == 0) {
        alert('제목을 입력해주세요');
        return;
    }

    // toast-ui-editor의 마크다운 내용 확인
    const editor = $(form).find('.toast-ui-editor').data('data-toast-editor');
    const markdown = $.trim(editor.getMarkdown());
    if (markdown.length == 0) {
        alert('내용을 입력해주세요');
        editor.focus();
        return;
    }
    // 마크다운 내용 폼에 저장
    form.body.value = markdown;

    // 폼 제출
    form.submit();
}

<!-- 조회수 증가 함수 -->
function ArticleDetail__doIncreaseHitCount() {
    const localStorageKey = 'article__' + params.id + '__alreadyOnView';

    if (localStorage.getItem(localStorageKey)) {
        return;
    }

    localStorage.setItem(localStorageKey, true);

    $.ajax({
        url: '/usr/article/doIncreaseHitCountRd',  // URL
        type: 'GET',                                  // HTTP 메서드
        data: {id: params.id, ajaxMode: 'Y'},       // 요청 데이터
        dataType: 'json',                             // 응답 데이터 타입
        success: function (data) {                     // 성공 시 콜백 함수
            $('.article-detail__hit-count').empty().html(data.data1);
        },
        error: function () {                           // 에러 시 콜백 함수
            console.error('조회수 증가 실패');
        }
    });
}

$(document).ready(function () {
    setTimeout(ArticleDetail__doIncreaseHitCount, 2000);
});

<!-- 좋아요 싫어요 처리 -->
function checkRP() {
    if (isAlreadyAddGoodRp) {
        $('#likeButton').toggleClass('btn-outline');
    } else if (isAlreadyAddBadRp) {
        $('#DislikeButton').toggleClass('btn-outline');
    }
}

function doGoodReaction(articleId) {
    if (params.memberId === 0) {
        if (confirm('로그인 창으로 이동할래?')) {
            let currentUri = encodeURIComponent(window.location.href);
            window.location.href = '/usr/member/login?afterLoginUri=' + currentUri;
        }
        return;
    }

    $.ajax({
        url: '/usr/reactionPoint/doGoodReaction',  // URL
        type: 'POST',                                    // HTTP 메서드
        data: {relTypeCode: 'article', relId: articleId},  // 전송할 데이터
        dataType: 'json',                                // 응답 데이터 타입
        success: function (data) {                        // 성공 시 콜백
            if (data.resultCode.startsWith('S-')) {
                $('#likeButton').toggleClass('btn-outline');
                $('#likeCount').text(data.data1);
                $('.likeCount').text(data.data1);
            } else {
                alert(data.msg);
            }
        },
        error: function () {                              // 오류 발생 시 콜백
            alert('좋아요 오류 발생');
        }
    });
}

function doBadReaction(articleId) {
    if (params.memberId === 0) {
        if (confirm('로그인 창으로 이동할래?')) {
            let currentUri = encodeURIComponent(window.location.href);
            window.location.href = /*[[@{/member/login}]]*/ +'?afterLoginUri=' + currentUri;
        }
        return;
    }

    $.ajax({
        url: '/usr/reactionPoint/doBadReaction',  // URL
        type: 'POST',                                   // HTTP 메서드
        data: {relTypeCode: 'article', relId: articleId},  // 전송할 데이터
        dataType: 'json',                               // 응답 데이터 타입
        success: function (data) {                       // 성공 시 콜백
            if (data.resultCode.startsWith('S-')) {
                $('#DislikeButton').toggleClass('btn-outline');
                $('#DislikeCount').text(data.data2);
                $('.DislikeCount').text(data.data2);
            } else {
                alert(data.msg);
            }
        },
        error: function () {                             // 오류 발생 시 콜백
            alert('싫어요 오류 발생');
        }
    });
}

$(document).ready(function () {
    checkRP();
});

<!-- 댓글 수정 -->

function toggleModifybtn(replyId) {
    $('#modify-btn-' + replyId).hide();
    $('#save-btn-' + replyId).show();
    $('#reply-' + replyId).hide();
    $('#modify-form-' + replyId).show();
}

function doModifyReply(replyId) {
    let form = $('#modify-form-' + replyId);
    let text = form.find('input[name="reply-text-' + replyId + '"]').val();

    $.ajax({
        url: '/usr/reply/doModify',  // URL
        type: 'POST',                       // HTTP 메서드
        data: {id: replyId, body: text},  // 전송할 데이터
        success: function (data) {           // 성공 시 콜백
            $('#modify-form-' + replyId).hide();
            $('#reply-' + replyId).text(data);
            $('#reply-' + replyId).show();
            $('#save-btn-' + replyId).hide();
            $('#modify-btn-' + replyId).show();
        },
        error: function () {                  // 오류 발생 시 콜백
            alert('댓글 수정에 실패했습니다');
        }
    });
}

<!-- 댓글 작성 -->
function ReplyWrite__submit(form) {
    form.body.value = form.body.value.trim();

    if (form.body.value.length < 3) {
        alert('3글자 이상 입력해');
        form.body.focus();
        return false;
    }

    form.submit();
}