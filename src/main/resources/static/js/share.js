
function setShare(){
    let shareImage = document.getElementsByTagName("img");
    const user_name = document.getElementById("writer-name").value;
    const shareImgURL = shareImage.item(0).src;
    const shareTitle = user_name + "님이 보낸 새해 카드 도착!";

    Kakao.Share.sendDefault({
        objectType: 'feed',
        content: {
            title: shareTitle,
            description: "당신에게 새해 카드가 도착했습니다! 어서 확인하러 가봅시다 :)",
            imageUrl: shareImgURL,
            link: {
                mobileWebUrl: url.value,
                webUrl: url.value,
            },
        },
        buttons: [
            {
                title: '카드 메시지 보러가기',
                link: {
                    mobileWebUrl: url.value,
                    webUrl: url.value,
                },
            },
        ]
    });
}
