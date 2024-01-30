<<<<<<< HEAD

function autoResize(textarea) {

    if(textarea.scrollHeight>textarea.clientHeight){
        console.log("+++")
        textarea.style.height = textarea.scrollHeight+"px";
    }
    else{
        if(textarea.scrollHeight > 106){
            console.log("---")
=======
// Textarea 자동 높이 조절
function autoResize(textarea) {
    if (textarea.scrollHeight > textarea.clientHeight) {
        textarea.style.height = textarea.scrollHeight + "px";
    }
    else {
        if(textarea.scrollHeight > 106) {
>>>>>>> cd993ff90a91172037b46d365e0dadc238fd2471
            textarea.style.height = (textarea.scrollHeight-24) + "px"
            autoResize(textarea);
        }
    }
}

// 페이지 로드 시 초기 호출
window.addEventListener('load', function() {
<<<<<<< HEAD
    autoResize(document.getElementById('autoResizeTextarea'));
});
=======
    autoResize(document.getElementById('textarea'));
});

>>>>>>> cd993ff90a91172037b46d365e0dadc238fd2471
