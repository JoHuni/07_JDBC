// 목록으로 버튼 동작
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {
    console.log("뭐");
    location.href = "/";
});

const completeBtn = document.querySelector(".complete-btn");

completeBtn.addEventListener("click", e => {

    // 요소.dataset : data-* 속성에 저장된 값 반환(객체)
    const todoNo = e.target.dataset.todoNo;
    let complete = e.target.innerText;    
    
    complete = (complete === 'Y') ? 'N' : 'Y';

    location.href = `/todo/changeComplete?todoNo=${todoNo}&complete=${complete}`;
});

const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", e =>{
    const todoNo = e.target.dataset.todoNo;
    location.href = `/todo/update?todoNo=${todoNo}`;
});

const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", e => {
    if(confirm("정말로 삭제 하시겠습니까?")){
        location.href = `/todo/delete?todoNo=${e.target.dataset.todoNo}`;
    }
});
