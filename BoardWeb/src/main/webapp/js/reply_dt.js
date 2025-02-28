/**
 * reply_dt.js
 */
let rno = 0;
new DataTable('#example', {
	ajax: 'datatable.do?bno=' + bnos,
	columns: [
		{ data: 'replyNo' },
		{ data: 'reply' },
		{ data: 'replyer' },
		{ data: 'replyDate' }
	]


});

const table = new DataTable('#example');
//댓글 선택 
table.on('click', 'tbody tr', (e) => {
	let classList = e.currentTarget.classList;

	if (classList.contains('selected')) {
		classList.remove('selected');
	}
	else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
		classList.add('selected');
	}
});

//댓글 삭제
document.querySelector('#delReply').addEventListener('click', function(e) {
	const sel = document.querySelector('#example tr.selected')
	console.log(sel.firstChild.innerText);
	rno = sel.firstChild.innerText;
	svc.removeReply(rno,
		function(result) {
			console.log(result);
			if (result.retCode == 'OK') {
				table.row('.selected').remove().draw(false);
				return
			} else {
				alert("처리중 오류")
			}
		},
		function(err) {
			console.log(err);
		}
	)


});

//댓글 등록
document.querySelector('#addReply').addEventListener('click', addNewRow);


function addNewRow() {
	const reply = document.querySelector("#reply");
	const replyer = logid;
	if (!reply || !replyer) {
		alert("필수 입력값 확인")
		return
	}
	const param = { bno: bno.value, reply: reply.value, replyer };
	svc.addReply(param,
		function(result) {
			if (result.retCode == 'OK') {
				console.log(result);
				table.row
					.add({
						"replyNo": result.retVal.replyNo,
						"reply": result.retVal.reply,
						"replyer": result.retVal.replyer,
						"boardNo": result.retVal.boardNo,
						"replyDate": result.retVal.replyDate
					})
					.draw(false);
			} else {
				alert("등록중 문제가 발생하였습니다.")
			}

		},
		function(err) {
			console.log(err);
		}
	)

}


