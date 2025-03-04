/**
 * array
 * forEach, filter, map, reduce 메소드
 */

let ary = [
  {id : 100, name: "홍길동", score:345},
  {id : 101, name: "김길동", score:459},
  {id : 101, name: "나길동", score:240},
  {id : 102, name: "오길동", score:500}
]
// ary.forEach(function(item,idx,array){
//   console.log("함수 선언");
//   console.log(item,idx,array);
  
// })
//forEach 매개변수로 item idex array 를 받아서 배열을 반복시키는 메소드
ary.forEach((item,idx,array) =>{
  console.log("화살표 함수");
  console.log(item,idx,array);
  
})
//filter 메소드 true인 값만 반환.
let filary = ary.filter(item=>{
  if(item.score > 400){
    return true
  }else{
    return false
  }
})
console.log(filary);
//map 기준에 맞는 값에대해 key값을 추가 할 수 있다.
let mapAry = ary.map(item=>{
  //A: 400, B: 300, C:그외
  if(item.score>400){
    item.group = 'A'
  }else if(item.score >300){
    item.group = 'B'
  }else{
    item.group = 'C'
  }
return item
}
)
console.log(mapAry);

//reduce 초기값을 설정하고 배열을 돌리면서 그 조건에 맞는 값을 다음 값으로 넘겨준다.
ary.reduce((acc,item,idx,array)=>{
  console.log(acc,item,idx,array);
  return item
},{})
let result = ary.reduce((acc,item)=>{
 
  return acc > item.score ? acc : item.score
},0)
console.log(result);
//filter같은 사용
result = ary.reduce((acc,item)=>{
  if(item.score > 300){
    acc.push(item)
  }
  return acc
},[])
console.log(result);
result = ary.reduce((acc,item)=>{
  let li = document.createElement('li')
  li.innerHTML = 'id: '+item.id+ 'name: '+ item.name
  acc.appendChild(li)
  return acc
},document.querySelector("#list"))