### 数据表

#### admin： 管理员信息表

id：编号**（主键）**

username：用户名

password：用户密码

#### user:  用户信息表

id: 编号**（主键）**

username: 用户名

password: 密码

email：电子邮件

tel：电话

carId: 卡号

gender: 性别

#### book: 图书信息表

id: 图书编号**（主键）**

bookName：图书名

author：作者

publish：出版社

publicationTime：出版时间

bookcaseId: 图书类别 **（外键）**

pages: 页数

prices：价格

availableQuantity：可用数量

totalTime: 图书总数

#### bookcase：图书类别清单

id: 编号**（主键）**

caseName: 类别名称

#### borrowstate: 借阅状态

id:编号**（主键）**

state：状态名称

#### borrow: 借阅表

id：借阅编号 **（主键）**

bookId：书本id**（外键）**

userId: 用户id **（外键）**

borrowTime: 借阅时间

approvalTime: 审批时间

returnTime: 还书时间

adminId: 审批员id **（外键）**

state：借阅状态



### 显示视图

##### 用户浏览界面视图

id: 图书编号**（主键）**

bookName：图书名

author：作者

publish：出版社

publicationTime: 出版时间

bookcaseId: 图书类别 **（外键）**

pages: 页数

prices：价格

availableQuantity：可用数量

##### 用户借阅历史视图

id: 编号**（主键）**

book.bookName：图书名

book.author：作者

book.publish：出版社

bookcase.caseName: 图书类别 **（外键）**

borrow.borrowTime: 借阅时间

borrow.approvalTime: 审批时间

borrow.returnTime: 归还时间

borrow.state: 借阅状态



##### 管理员浏览界面视图

id: 图书编号**（主键）**

bookName：图书名

author：作者

publish：出版社

publicationTime: 出版时间

bookcaseId: 图书类别 **（外键）**

pages: 页数

prices：价格

availableQuantity：可用数量

totalQuantity: 图书总数

##### 管理员借阅历史视图

id: 编号**（主键）**

book.bookName：图书名

book.author：作者

book.publish：出版社

bookcase.caseName: 图书类别 **（外键）**

userId: 借阅人员 （外键）

adminId: 审批人员 （外键）

borrow.borrowTime: 借阅时间

borrow.approvalTime: 审批时间

borrow.returnTime: 归还时间

borrow.state: 借阅状态





 











