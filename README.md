# WeatherApp
毕设项目，天气预报app，模仿郭霖老师的《第一行代码》第三版
用Java代码实现



<img width="281" alt="image" src="https://user-images.githubusercontent.com/55468403/151373362-aa82bd15-da54-4b0e-8abc-0caa205d6b85.png">

本设计采用的是MVVM框架,UI控制层包含了我们平时写的Activity,Fragment,布局文件等与界面相关的东西
ViewModel层用于持有UI层相关的数据,保证数据在旋转屏幕时不会丢失,并且提供接口供UI调用和仓库层进行通信
仓库层作用是判断调用方请求的数据是从本地数据源获取还是从网络数据源获取
本地数据源使用SharedPreferences持久化技术实现
网络数据源使用Retrofit访问服务器提供Webservice接口实现
