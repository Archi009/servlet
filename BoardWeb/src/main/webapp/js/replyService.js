/**
 *replyService 
 */

 const svc ={
	name: "Hong",
	showName: function(){
		return this.name;
	},
	//목록 메소드
	replyList : function(param = {bno, page},successCallbackFnc,errorCallbackFnc){
		fetch("replyList.do?bno="+param.bno+"&page="+param.page)
		.then(function(result){
			return result.json()
		})
		.then(successCallbackFnc)
		.catch(errorCallbackFnc)
	},
	//등록 메소드
	addReply(param={},successCallbackFnc,errorCallbackFnc){
		fetch("addReply.do?bno="+param.bno+"&reply="+param.reply+"&replyer="+param.replyer)
		.then(result=> result.json())
		.then(successCallbackFnc) //성공시 실행 함수
		.catch(errorCallbackFnc)	//실패시 실행 함수

	},
	//삭제 메소드
	removeReply(rno=1,successCallbackFnc,errorCallbackFnc){
		fetch("removeReply.do?rno="+rno )
		.then(result=> result.json())
		.then(successCallbackFnc) //성공시 실행 함수
		.catch(errorCallbackFnc)	//실패시 실행 함수
	},
	//페이징 계산
	makePaging(bno=1,successCallbackFnc,errorCallbackFnc){
		fetch("getReplyCnt.do?bno="+bno )
		.then(result=> result.json())
		.then(successCallbackFnc) //성공시 실행 함수
		.catch(errorCallbackFnc)	//실패시 실행 함수
	}
 }