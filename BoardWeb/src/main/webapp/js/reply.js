/**
 * reply.js
 */
//댓글
let page = 1;
function makeReply(reply = {}) {
	let html = `<li class="li" data-id="${reply.replyNo}">
				<span class="col-sm-2">${reply.replyNo}</span>
				<span class="col-sm-5">${reply.reply}</span>
				<span class="col-sm-2">${reply.replyer}</span>
				<span class="col-sm-2"><button class="btn btn-warning" onclick="deleteRow('${reply.replyNo}')">삭제</button></span>
			</li>`;
	return html
}


//목록
function showPagelist() {
	svc.replyList({ bno: bno.value, page: page },
		function(result) { //성공함수
			document.querySelectorAll('li[data-id]').forEach(function(elem) {
				elem.remove()
			})
			let resultAry = result;
			resultAry.forEach(reply => {
				let target = document.querySelector('.reply>.content>ul')
				target.insertAdjacentHTML('beforeend', makeReply(reply))
			});

		}, function(err) { //실패 함수
			console.log(err);
		});
}
showPagelist();


//페이징 생성
function showPagingList() {
	svc.makePaging(bno.value,
		function(result) {
			console.log(result);
			let target = document.querySelector('div.footer>nav>ul')
      target.innerHTML = '';
			let html = ''
			const totalCnt = result.totalCnt;
			// startPage, endPage, currPagge 
			// prev, next
			let currPagge = page;
			console.log(currPagge);
			let endPage = Math.ceil(currPagge / 10) * 10;
			let startPage = endPage - 9;
			console.log(startPage);
			let realEnd = Math.ceil(totalCnt / 5);
			endPage = endPage > realEnd ? realEnd : endPage;
			let prev = startPage != 1 ? true : false;
			let next = endPage != realEnd ? true : false;
			//링크 생성
			console.log(prev);
			console.log(next);
      console.log(currPagge+"currentPage");
      console.log(endPage+"endpage")
      //이전페이지 존재 유무 확인
			if (prev) {
				html = `<li class="page-item ">
					<a class="page-link" href="#"	tabindex="-1" data-page="${startPage - 1}">Previous</a></li>`

			} else {
				html = `<li class="page-item disabled">
					  <a class="page-link" href="#"	tabindex="-1">Previous</a></li>`
			}
			target.insertAdjacentHTML('beforeend', html)
			console.log(html);
			for (let p = startPage; p <= endPage; p++) {
        if(p==currPagge){
          html = `<li class="page-item active" ><a class="page-link" href="#" data-page="${p}">${p}</a></li>`
        }else{
          html = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`
        }
				target.insertAdjacentHTML('beforeend', html)
			}
      //이후페이지 존재 유무 확인
			if (next) {
				html = `<li class="page-item ">
         <a class="page-link" href="#"	tabindex="-1" data-page="${endPage + 1}">Next</a></li>`

			} else {
				html = `<li class="page-item disabled">
         <a class="page-link" href="#"	tabindex="-1">Next</a></li>`
			}
			target.insertAdjacentHTML('beforeend', html)
			console.log(html);

			//화면 a태그에 이벤트 등록
			addLink()


		},
		function(err) {
			console.log(err);
		}
	)
}


// 등록 이벤트 
document.querySelector("#addReply").addEventListener('click', function() {
	//원글 번호 bno.value 작성자 logId 댓글? 
	const reply = document.querySelector("#reply");
	const replyer = logid;
	if (!reply || !replyer) {
		alert("필수 입력값 확인")
		return
	}
	console.log(logid);
	const param = { bno: bno.value, reply: reply.value, replyer };

	svc.addReply(param,
		function(result) {
			if (result.retCode == 'OK') {
				// let target = document.querySelector('.reply>.content>ul')
				// target.insertAdjacentHTML('beforeend', makeReply(result.retVal))
        page = 1; //등록하면 첫 페이지 보여주기
        showPagelist()
        showPagingList()
				reply.value = ''

			}

			console.log(result);
		},
		function(err) {

		});

})

//삭제
function deleteRow(rno) {
  if(!confirm("삭제하시겠습니까?")){
    alert("취소합니다")
    return
  }
	svc.removeReply(rno,
		function(result) {//성공함수
			if (result.retCode == 'OK') {
       
        

          document.querySelector("li[data-id = '" + rno + "']").remove()
          showPagelist()
          showPagingList()
        
			}
		},
		function(err) {//실패함수
			console.log(err);
		}
	)
}

function addLink() {

	//페이징 목록의 링크() 이벤트. [a,a,a,a,a,a,a,,,,]
	document.querySelectorAll('div.footer>nav a').forEach(function(item) {
		item.addEventListener('click', function(e) {
			e.preventDefault()
			page = e.target.getAttribute('data-page') //링크 클릭시 페이지 정보
			//목록 보기
			showPagelist();
			//페이징
			showPagingList()
		})
	})
}
showPagingList()