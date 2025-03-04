/**
 * api.js
 */
let centerAll = [];


fetch("https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=fnNvgI%2F85j%2FrXVYeAtfnN1hGMK65xH8FI5d1cG2%2By9hoNLV17dHqrp2VmlXr%2BrKWCccdvk95IS5QYa82JbKilg%3D%3D")
    .then(result=>result.json())
    .then(result=>{
      console.log(result.data);
      centerAll = result.data
      makeSidoList()
     
      
    })
	.catch(err=>console.log(err))

  function makeSidoList(){
    let sidoList = [] 
    for(let i =0 ; i<centerAll.length;i++){
      if(sidoList.indexOf(centerAll[i].sido)==-1){
        sidoList.push(centerAll[i].sido);
      }
    }
    console.log(sidoList);
    sidoList.forEach(sido => {
      let opt = document.createElement('option');
      opt.innerHTML = sido
      document.getElementById('centerList').appendChild(opt)
    })
  }
  function makeCenterList(filterSido=[]){
    document.getElementById('list').innerHTML = ''

    let fields = ['id','centerName','phoneNumber','sido']
    //센터정보
    filterSido.forEach(center =>{
      //tr>td*4
      let tr =document.createElement('tr')
      tr.setAttribute("lat",center.lat)
      tr.setAttribute("lng",center.lng)
      tr.addEventListener('click',pointMap)
      
      fields.forEach(item=>{
        let td = document.createElement('td')
        td.innerHTML = center[item]
   
        tr.appendChild(td)
      })
      document.getElementById('list').appendChild(tr)
    })
  }
  document.getElementById('centerList').addEventListener('change',function(e){
    console.log(e.target.value);
    let sidoNm = e.target.value
    let filterSido=[]
    
    filterSido= centerAll.filter(item=>{
      if(item.sido ==  sidoNm){
        return true
      }else{
        return false
      }
    })
    console.log(filterSido);
    makeCenterList(filterSido)
  })

  function pointMap(e){
    console.log(e);
    console.log(e.target.parentElement);
    let tr = e.target.parentElement
    let loc = tr.children[1].innerText.substring(6)
  
    console.log(tr.children[1]);
    window.open('map.do?lat='+tr.getAttribute('lat')+'&lng='+tr.getAttribute('lng')+'&loc='+loc)
  }