function submit() {
    var bookname = document.getElementById('bookname');
    var author = document.getElementById('author');
    var publisher = document.getElementById('publisher');
    var publisheDate = document.getElementById('publishDate');
    var num = document.getElementById('num');
    if(bookname.value === ""){
        alert("请输入图书名称!");
    }else if(author.value === ""){
        alert("请输入作者!");
    }else if(publisher.value === ""){
        alert("请输入出版社!");
    }else if(publisheDate.value === ""){
        alert("请输入出版年份！");
    }else if(publisheDate.value >= 2021){
        alert("输入的出版年份不正确！请重新输入！");
    }else if(num.value === ""){
        alert("请输入库存！")
    }else if(num.value <= 0){
        alert("请输入有效库存量！")
    }else{
        alert("登记成功！");
        /*
        bookname.value = "";
        author.value = "";
        publisheDate.value = "";
        publisher.value = "";
        num.value = "";
        */
    }
}