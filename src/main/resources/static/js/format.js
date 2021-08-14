window.onload = () => {
    alert("가자");

    const formatFile = document.getElementById("formatFile");
    formatFile.addEventListener("change", handleFiles, false);
}

function handleFiles() {
    const fileList = this.files; /* 이제 파일 리스트로 작업할 수 있습니다 */
    alert(fileList[0]);
}

