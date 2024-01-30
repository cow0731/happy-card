
function autoResize(textarea) {

    if(textarea.scrollHeight>textarea.clientHeight){
        console.log("+++")
        textarea.style.height = textarea.scrollHeight+"px";
    }
    else{
        if(textarea.scrollHeight > 106){
            console.log("---")
            textarea.style.height = (textarea.scrollHeight-24) + "px"
            autoResize(textarea);
        }
    }
}

// 페이지 로드 시 초기 호출
window.addEventListener('load', function() {
    autoResize(document.getElementById('autoResizeTextarea'));
});