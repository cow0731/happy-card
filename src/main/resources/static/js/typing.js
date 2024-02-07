const target = document.querySelector("#typingTextarea"); //html에서 dynamic 선택
const area = document.getElementById("typingTextarea");
//함수 만들기
function blink(){
    target.classList.toggle("active"); // dynamic에 active 클래스 추가<->삭제 반복
}

const regex = /^\s+|\s+$/gm;
let string = document.getElementById("autoResizeTextarea").value; //원하는 텍스트를 string변수 선언
string = string.replace(regex, '');
const stringLen = string.split('\n').length;

console.log(string)
console.log(stringLen)

function resizeArea(){
    area.style.height = area.scrollHeight +'px';
}

const split = string.split(""); //string의 텍스트를 여러개의 문자열로 나눠줌

function resizeArea(){
    area.style.height = area.scrollHeight +'px';
}

//문자열을 한개씩 나타내주는 함수 만들기
function dynamic(arr){
    if(arr.length > 0){ //배열의 길이가 0보다 크면(배열에 요소가 하나라도 있다면)g\
        target.textContent += arr.shift();//dynamic에 textContent에 배열의 요소 추가
        resizeArea();
        setTimeout(function(){
            dynamic(arr)}, 80)//0.08초 후에 daynamic함수를 실행
    }
}
dynamic(split); //dynamic함수에 split인자 넣어서 실행