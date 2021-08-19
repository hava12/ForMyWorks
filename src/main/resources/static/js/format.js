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

    fetch("/format/file", {
        method: "POST",
        body: formData
    }).then((res) => res.json())
        .then((response) => {
            const table = document.querySelector("#form-table");
            let tr = null
            let nameTd = null
            let valueTd = null
            let inputText = null

            response.forEach((item) => {
                tr = document.createElement("tr")
                nameTd = document.createElement("td")
                valueTd = document.createElement("td")
                inputText = document.createElement("input")

                inputText.setAttribute("type","text");
                inputText.setAttribute("maxlength",item.length);
                nameTd.innerText = item.name;

                valueTd.appendChild(inputText);
                tr.appendChild(nameTd);
                tr.appendChild(valueTd);
                table.appendChild(tr);
            })
        }).catch((e) => {
        alert("error")
    });

}

