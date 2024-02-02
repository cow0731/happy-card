const modal = document.querySelector('.modal-container');
const modalOpen = document.querySelector('.send-btn');
const modalClose = document.querySelector('.share-btn');

let url = document.getElementById("card-url");

//열기 버튼을 눌렀을 때 모달팝업이 열림
modalOpen.addEventListener('click',function(){
    //'on' class 추가
    modal.classList.add('on');
});
//닫기 버튼을 눌렀을 때 모달팝업이 닫힘
modalClose.addEventListener('click',function(){
    //'on' class 제거
    modal.classList.remove('on');
});

function sendBtnClick() {
    const card_id = document.getElementsByName("id")[0].value;
    const contents = document.getElementById("autoResizeTextarea").value;
    console.log('카드id: '+ card_id)
    console.log('카드내용: '+ contents)

    let jsonArray = [];
    let jsonObj = {};
    jsonObj.id = card_id;
    jsonObj.write_content = contents;
    jsonArray.push(jsonObj);
    console.log(jsonArray)

    asyncTest(card_id, jsonArray);
}

function asyncTest(card_id, data){
    let url = '/write-card/'+ card_id;
    // Post 비동기 쿼리스트링 전송
    fetch(url, {
        method : 'post',
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify(data)
    }).then(res=> {
        res.text().then(function(text){
            console.log("자바단 데이터 = " + text);
            url = document.getElementById("card-url");
            url.value = "http://localhost:8082/read-card?writeCardId="+ text;
        })
    })
    .catch(err=> {
        console.log(err);
    })
}

function copyURL() {
    // navigator.clipboard.writeText(url.value).then(res => {
    //     alert("URL이 복사되었습니다!");
    // })
    let clipboard = new ClipboardJS('.btn');
    clipboard.on('success', function(e) {
        alert("URL 복사가 완료되었습니다!")
    });
    clipboard.on('error', function(e) {
        console.log(e);
    });
}