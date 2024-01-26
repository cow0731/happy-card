window.onload = function() {

    function resize() {
        textarea.style.height = "0px";

        let scrollHeight = textarea.scrollHeight;
        let style = window.getComputedStyle(textarea);
        let borderTop = parseInt(style.borderTop);
        textarea.style.height = (scrollHeight + borderTop + borderBottom) + "px";

        let borderBottom = parseInt(style.borderBottom);
    }

    let textarea = document.getElementById("message-box");
    textarea.addEventListener("input", resize);
}