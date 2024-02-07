// Textarea 자동 높이 조절
function autoResize(textarea) {
    if (textarea.scrollHeight > textarea.clientHeight) {
        textarea.style.height = textarea.scrollHeight + "px";
    }
    else {
        if(textarea.scrollHeight > 106) {
            textarea.style.height = (textarea.scrollHeight-24) + "px"
            autoResize(textarea);
        }
    }
}

// 페이지 로드 시 초기 호출
window.addEventListener('load', function() {
    autoResize(document.getElementById('autoResizeTextarea'));
});
