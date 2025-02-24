/**
 * member.js
 */

fetch("testData.do")
.then(function(result){
  return result.json(); // stream -> object
})
.then(function(result){
  const memberAry = result;
  memberAry.forEach(item => {
    const target =  document.querySelector("tbody#list")
    const html = `<tr>
            <td>${item.memberId}</td>
            <td>${item.passwd}</td>
            <td>${item.memberName}</td>
            <td>${item.responsibility}</td>
            <td><button class="btn btn-danger" onclick="deleteRow('${item.memberId}')">삭제</button></td>
        </tr>`
    target.insertAdjacentHTML('beforeend',html)
  });

})

function deleteRow(id){
  console.log(id);
  fetch(`removeMember.do?mid=${id}`)
  .then(function(result){
    return result.json()
  }).then((result) => {
    console.log(result);
    if(result.retCode == 'OK'){
      this.parentElement.parentElement.remove()
    }else{
      alert("삭제오류")
    }
  })
}
