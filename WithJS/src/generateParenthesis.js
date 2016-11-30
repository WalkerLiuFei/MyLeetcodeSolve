/**
 * Created by Administrator on 2016/10/20 0020.
 */

window.onload = function(){
    console.log(generateParenthesis(3));
}
var generateParenthesis = function(n) {
    console.log("loaded")
    var result = [];
    backTracking(2*n,n,1,0,1,"(",result); //长度为2*nde 字符串满足条件！
    return result;
};

function backTracking(resLength,paraNum, leftAdded,rightAdded,flag,cont,result){
    if (flag < 0 || rightAdded > paraNum || leftAdded > paraNum)
        return;
    if (cont.length == resLength)
        result.push(cont);

    if (flag > 0)
        backTracking(resLength,paraNum,leftAdded,rightAdded+1,flag-1,cont+")",result);

    if (flag >=0)
        backTracking(resLength,paraNum,leftAdded+1,rightAdded,flag+1,cont+"(",result);
}