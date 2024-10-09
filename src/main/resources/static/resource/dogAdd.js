// DOM이 준비되면 실행
$(document).ready(function() {
    const $dropArea = $('.drop_area'); // 드롭 영역 선택
    const $inputFile = $('.dog_photo'); // 파일 입력 필드 선택
    const $preview = $('#preview'); // 미리보기 이미지 선택

    // 드래그 오버 이벤트
    $dropArea.on('dragover', function(event) {
        event.preventDefault(); // 기본 동작 방지
        $(this).addClass('highlight'); // 드롭 영역 강조
    });

    // 드래그 리브 이벤트
    $dropArea.on('dragleave', function() {
        $(this).removeClass('highlight'); // 드롭 영역 강조 제거
    });

    // 드롭 이벤트
    $dropArea.on('drop', function(event) {
        event.preventDefault(); // 기본 동작 방지
        $(this).removeClass('highlight'); // 드롭 영역 강조 제거

        const files = event.originalEvent.dataTransfer.files; // 드롭된 파일 가져오기
        if (files.length > 0) {
            $inputFile[0].files = files; // 파일 입력 필드에 드롭된 파일 설정

            // 파일 읽기
            const fileReader = new FileReader();
            fileReader.onload = function(e) {
                $preview.attr('src', e.target.result); // 미리보기 이미지 src 설정
                $preview.show(); // 이미지 표시
            }
            fileReader.readAsDataURL(files[0]); // 파일을 Data URL로 읽기
        }
    });
});
