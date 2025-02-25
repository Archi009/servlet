/**
 *replyService 
 */

 const svc ={
	name: "Hong",
	showName: function(){
		return this.name;
	},
	//목록 메소드
	replyList : function(bno,successCallbackFnc,errorCallbackFnc){
		fetch("replyList.do?bno="+bno)
		.then(function(result){
			return result.json()
		})
		.then(successCallbackFnc)
		.catch(errorCallbackFnc)
	},
	//등록 메소드
	addReply : function(param={},successCallbackFnc,errorCallbackFnc){
		fetch("addReply.do?bno="+param.bno+"&reply="+param.reply+"&replyer="+param.replyer)
		.then(result=> result.json())
		.then(successCallbackFnc) //성공시 실행 함수
		.catch(errorCallbackFnc)	//실패시 실행 함수

	},
	//삭제 메소드
	removeReply : function(rno=1,successCallbackFnc,errorCallbackFnc){
		fetch("removeReply.do?rno="+rno )
		.then(result=> result.json())
		.then(successCallbackFnc) //성공시 실행 함수
		.catch(errorCallbackFnc)	//실패시 실행 함수
	}
 }