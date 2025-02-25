/**
 * reply.js
 */
//댓글
function makeReply(reply = {}){
  let html = `<li class="li" data-id="${reply.replyNo}">
				<span class="col-sm-2">${reply.replyNo}</span>
				<span class="col-sm-5">${reply.reply}</span>
				<span class="col-sm-2">${reply.replyer}</span>
				<span class="col-sm-2"><button class="btn btn-warning" onclick="deleteRow('${reply.replyNo}')">삭제</button></span>
			</li>`;
      return html
}


//목록
svc.replyList(bno.value, 
  function(result) { //성공함수
              let resultAry = result;
              resultAry.forEach(reply => {
                let target = document.querySelector('.reply>.content>ul')
                target.insertAdjacentHTML('beforeend', makeReply(reply))
	});

}, function(err) { //실패 함수
	console.log(err);
});


// 등록 이벤트 
document.querySelector("#addReply").addEventListener('click',function(){
  //원글 번호 bno.value 작성자 logId 댓글? 
  const reply = document.querySelector("#reply");
  const replyer = logid;
  if(!reply || !replyer){
    alert("필수 입력값 확인")
    return
  }
console.log(logid);
  const param = { bno : bno.value ,reply : reply.value,replyer};
  
  svc.addReply(param, 
    function(result){
      if(result.retCode == 'OK'){
        let target = document.querySelector('.reply>.content>ul')
        target.insertAdjacentHTML('beforeend', makeReply(result.retVal))
        reply.value =''

      }
      
      console.log(result);
    },
    function(err){

    });
  
})

function deleteRow(rno){
  svc.removeReply(rno,
    function(result){//성공함수
      if(result.retCode == 'OK'){
        document.querySelector("li[data-id = '"+rno+"']").remove()
      }
    },
    function(err){//실패함수
      console.log(err);
    }
  )
}
