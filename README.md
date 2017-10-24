# Spring-Boot-Jwt-Security
# api访问地址
http://localhost:8001/swagger-ui.html
# 登录验证
在authenticationManager.authenticate(upToken)中完成用户名、密码验证以及权限的加载，密码采用BCryptPasswordEncoder方式验证

# 接口调用
在header中添加
Authorization BearereyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1MDg4MzU0MTE3MzYsImV4cCI6MTUwOTQ0MDIxMX0.tEJlc_QMIFU39FIpqMz9zTQFNAfp4KG8FGRo_6032deVtL92-UVq9xaDBT9e1LKUSNoobZhNqFMYFDhbVnq30w

