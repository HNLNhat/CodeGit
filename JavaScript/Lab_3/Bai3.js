var so1 = null;
var so2 = null;
var pheptinh = null;
var kq = null;

function ganso(x){
    if(so1==null) so1 = x;
    else so2 = x;
    console.log("Số 1 = " + so1);
    console.log("Số 2 = " + so2);
}
function ganpheptinh(x){
    pheptinh=x;
    console.log(x);
}    
function thuc_hien(){
if(pheptinh=='+') kq=so1+so2;
if(pheptinh=='-') kq=so1-so2;
if(pheptinh=='x') kq=so1*so2;
if(pheptinh==':') kq=so1/so2;
alert(kq);
}
function lam_lai(){
so1 = null;
so2 = null;
pheptinh = null;
kq= null;
}    