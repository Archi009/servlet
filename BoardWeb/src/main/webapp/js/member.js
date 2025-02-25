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
    const html = `<tr id=tr_${item.memberId}>
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
  fetch("removeMember.do?mid="+id) //서버처리
  .then(function(result){
    return result.json()
  }).then((result) => {
    console.log(result);
    if(result.retCode == 'OK'){
      document.querySelector("#tr_"+id).remove();
      
    }else if(result.retCode =="NG"){	

      alert("삭제오류")
    }else{
      alert("알 수 없는 오류")
    }
  })
}

document.querySelector("#addMember").addEventListener("click",function(){
  console.log("클릭");
  const id = document.querySelector("input[name='mid']").value
  const pw = document.querySelector("input[name='mpw']").value
  const name = document.querySelector("input[name='mname']").value
  
  console.log(id + pw+name)
  fetch("addMember.do?mid="+id+"&mpw="+pw+"&mname="+name)
  .then(function(result){
    return result.json()
  }).then((result)=>{
    console.log(result);
    if(result.retCode == 'OK'){
		console.log("성공")
		const target =  document.querySelector("tbody#list")
		    const html = `<tr id=tr_${id}>
		            <td>${id}</td>
		            <td>${pw}</td>
		            <td>${name}</td>
		            <td>User</td>
		            <td><button class="btn btn-danger" onclick="deleteRow('${id}')">삭제</button></td>
		        </tr>`
		    target.insertAdjacentHTML('beforeend',html)
      
    }else if(result.retCode =="NG"){	

      alert("등록오류")
    }else{
      alert("알 수 없는 오류")
    }
  })
})