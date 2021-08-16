window.onload = () => {
    const formatFile = document.getElementById("formatFile");
    formatFile.addEventListener("change", handleFiles, false);
}

function handleFiles() {
    const fileList = this.files; /* 이제 파일 리스트로 작업할 수 있습니다 */

    const formData = new FormData();
    for (let i = 0, numFiles = fileList.length; i < numFiles; i++) {
        formData.append('file', fileList[i]);
    }
    console.log(formData);

    fetch("/format/file", {
        method: "POST",
        body: formData
    }).then(
        alert("123123")
    ).catch(
        alert("error발생")
    );

}

