const modal = document.querySelector('.modal-container');
const modalOpen = document.querySelector('.send-btn');
const modalClose = document.querySelector('.share-btn');

let url = document.getElementById("card-url");

//열기 버튼을 눌렀을 때 모달팝업이 열림
// modalOpen.addEventListener('click',function(){
//     //'on' class 추가
//     modal.classList.add('on');
// });
//닫기 버튼을 눌렀을 때 모달팝업이 닫힘
modalClose.addEventListener('click',function(){
    //'on' class 제거
    modal.classList.remove('on');
});

//1. 토스트 메시지, 버튼요소를 변수에 대입
const toastMessage = document.getElementById('toast_message');
const toastMessageCopy = document.getElementById('toast_message_copy');

//2. 토스트 메시지 노출-사라짐 함수 작성
function toastOn(){
    toastMessage.classList.add('active');
    setTimeout(function(){
        toastMessage.classList.remove('active');
    },1500);
}

function toastOnCopy(){
    toastMessageCopy.classList.add('active');
    setTimeout(function(){
        toastMessageCopy.classList.remove('active');
    },1500);
}

function sendBtnClick() {
    const regex_gap = /^\s+|\s+$/gm;
    const card_id = document.getElementsByName("id")[0].value;
    let contents = document.getElementById("autoResizeTextarea").value;
    let writer_name = document.getElementById("writer-name").value;
    let cont = document.getElementById("autoResizeTextarea")
    let write = document.getElementById("writer-name")
    writer_name = writer_name.replace(regex_gap, '');
    contents = contents.replace(regex_gap, '');
    console.log("btn click");
    if (writer_name ===''){
        write.style.boxShadow = "0 0 10px rgba(255,0,0,0.50)";
        write.style.border = 'none';
    } else{
        write.style.border = '1px solid #dee2e6';
        write.style.boxShadow = "none";
    }
    if (contents === ''){
        cont.style.boxShadow = "0 0 10px rgba(255,0,0,0.50)";
    }
    else{
        cont.style.boxShadow = "none";
    }
    if ((writer_name === '') || (contents === '')) {
        toastOn();
        return;
    }

    console.log('카드id: '+ card_id)
    console.log('카드내용: '+ contents)
    console.log('작성자이름: '+ writer_name)

    let jsonArray = [];
    let jsonObj = {};
    jsonObj.id = card_id;
    jsonObj.write_content = contents;
    jsonObj.writer_name = writer_name;
    jsonArray.push(jsonObj);
    console.log(jsonArray)

    asyncTest(card_id, jsonArray);
    modal.classList.add('on');
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
    let clipboard = new ClipboardJS('.btn');
    clipboard.on('success', function(e) {
        toastOnCopy();
    });
    clipboard.on('error', function(e) {
        console.log(e);
    });
}