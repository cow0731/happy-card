
function setShare(){
    var shareImage = document.getElementsByTagName("img");
    var img = shareImage.item(0).src;

    const shareImgURL = img;
    const shareTitle = "설날 감사 메시지";

    Kakao.Share.sendDefault({
        objectType: 'feed',
        content: {
            title: shareTitle,
            description: "설날 감사 메시지가 도착했습니다!",
            imageUrl: shareImgURL,
            link: {
                mobileWebUrl: url.value,
                webUrl: url.value,
            },
        },
        buttons: [
            {
                title: '메시지 확인하기',
                link: {
                    mobileWebUrl: url.value,
                    webUrl: url.value,
                },
            },
        ]
    });
}

function kakaoShare(){

}