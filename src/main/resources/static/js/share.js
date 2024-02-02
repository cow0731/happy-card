const url = "http://localhost:8082/"
function setShare(ShareURL){
    var shareImage = document.getElementsByTagName("img");
    var img = shareImage.item(0).src;
    console.log(img);

    const shareURL = ShareURL;
    const shareImgURL = img;
    const shareTitle = "설날 감사 메시지";
    console.log(img);

    Kakao.Share.sendDefault({
        objectType: 'feed',
        content: {
            title: shareTitle,
            description: "설날 감사 메시지가 도착했습니다!",
            imageUrl: 'https://mud-kage.kakao.com/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg',
            link: {
                mobileWebUrl: url + "read-card?writeCardId=3",
                webUrl: url + "read-card?writeCardId=3",
            },
        },
        buttons: [
            {
                title: '메시지 확인하기',
                link: {
                    mobileWebUrl: url + "read-card?writeCardId=3",
                    webUrl: url + "read-card?writeCardId=3",
                },
            },
        ]
    });
}

function kakaoShare(){

}