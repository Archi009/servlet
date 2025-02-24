/**
 * test.js
 * 
 * 
 */
console.log("경로정상");

let json = `{"name":"홍길동","age":20}`

console.log(json);
let obj = JSON.parse(json)
document.querySelector("input[name='name']").value = obj.name;
document.querySelector("input[name='age']").value = obj.age;

//서버(서블릿) - jsp페이지. 
//서버의 데이터 페이지를 호출하면 받아온 데이터로 화면을 구성함
console.log('1');
fetch('testData.do')
.then(function(result){
  console.log(result); //body: stream
  return result.json(); // strea(json문자열)-> object 변환
})
.then(function(result){
  console.log(result);
  document.querySelector("input[name='name']").value = result.name;
  document.querySelector("input[name='age']").value = result.age;
  console.log('2');
  
})
//Ajax (Asynchronous Javaxcript And Xml)
//비동기 방식의 자바스크립트와 xml 
//
console.log('3');
console.log('4');
