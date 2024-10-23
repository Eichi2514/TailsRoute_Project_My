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
        alert('내용이 너무 짧습니다');
        form.body.focus();
        return false;
    }

    form.submit();
}