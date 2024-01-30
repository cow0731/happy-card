const formObj = document.querySelector("#f1")
document.querySelector(".subbtn").addEventListener("click",function (e){
    e.preventDefault()
    e.stopPropagation()

    formObj.method = 'post'
    formObj.submit()
}, false)