function submit() {
    const a = document.getElementById('password');
    const b = document.getElementById('bigbox');
    const c = document.getElementById('user')
    if(c.value === ""){
        alert("请输入用户名！");
    }else if (a.value === '123') {
        console.log('yes');
        b.style.animation = 'myAnimation 5s';
        b.style.animationFillMode = 'forwards';
        setTimeout(jump, 4000);
    }else{
        alert("密码错误！");
    }
}
function jump() {
    top.location.href = ("book");
}