# dm

#### 介绍
整合大漠插件函数

#### 软件架构
软件架构说明


#### 安装教程

1.  1.0.0版本对应大漠插件v71830版本
2.  使用前jacob-1.14.3-x86.dll放到C:\Windows\System32目录下,jacob-1.14.3-x64.dll放到C:\Windows\SysWOW64目录下
3.  xxxx

#### 使用说明

一、 大漠盾使用说明
    函数简介:

针对部分检测措施的保护盾.  前面有五角星的表示同时支持32位和64位,否则就仅支持64位.
驱动功能支持的系统版本号为(win7/win8/win8.1/win10(10240)/win10(10586)/win10(14393)/win10(15063)/win10(16299)/win10(17134)
不支持所有的预览版本,仅仅支持正式版本.

函数原型:

long DmGuard(enable,type)

参数定义:

enable 整形数:
0表示关闭保护盾(仅仅对memory memory2 memory3 b2 b3起作用)
1表示打开保护盾

type 字符串: 参数具体内容可以是以下任意一个. 所有驱动功能仅支持64位(win7 win7sp1 win8 win8.1 win10)
★"np" : 这个是防止NP检测(这个盾已经过时,不建议使用).
★"memory" : 这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)
★"memory2" : 这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)
"memory3 pid addr_start addr_end" : 这个保护内存系列接口和汇编接口可以正常运行.pid表示要操作内存的进程ID,指定了以后,所有内存系列接口仅能对此pid进程进行操作,其他进程无效. 但此盾速度较快。addr_start表示起始地址(此参数可以忽略),addr_end表示结束地址(此参数可以忽略). 另外，如果你发现有地址读写不到，可以尝试重新调用一次此盾.此盾是对指定的PID，指定的地址范围做快照. (此模式需要加载驱动)
"memory4" : 这个保护内存系列接口和汇编接口可以正常运行. (此模式需要加载驱动)

★"display2" : 同display,但此模式用在一些极端的场合. 比如用任何截图软件也无法截图时，可以考虑这个盾.

★"display3 <hwnd>" : 此盾可以保护当前进程指定的窗口(和子窗口)，无法被用正常手段截图. hwnd是必选参数. 并且必须是顶级窗口. 此盾有限制,具体查看下方的备注.

★"block [pid]" : 保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式.（此模式需要加载驱动,另外此盾在64位系统下无法隐藏驱动,调用后会让驱动无法隐藏,所以64位系统下,不太建议使用此盾)

★"b2 [pid]" : 保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式.(此模式需要加载驱动),另外,b2盾有副作用，会导致任何和音频输出的函数无声音(比如，Play和Beep函数，或者类似此函数实现的方式. 解决办法是另外创建一个进程用来播放音乐). 另外要特别注意，个别系统上，会出现保护进程退出时，导致系统蓝屏，解决办法是在进程结束前，关闭b2盾即可.

"b3 [pid]" : 保护指定进程不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程,另种实现方式.(此模式需要加载驱动),另外,b3盾有副作用，会导致无法创建线程，无法结束线程,无法操作某些系统API(比如打开文件对话框)，无法绑定目标窗口等等,解决办法是，临时关闭b3，进行你的操作,然后再打开b3。

"f1 [pid]" : 把当前进程伪装成pid指定的进程，可以保护进程路径无法被获取到.如果省略pid参数，则伪装成svchost.exe进程. (此模式需要加载驱动),另外，简单游平台专用版本无法使用此盾，原因是和简单游有冲突。   还有，使用此盾后，别人无法获取到你的进程的真实路径，但自己也同样无法获取，所以如果要获取真实路径，请务必在获取到路径后保存，再调用此盾. pid参数如果有效，那必须是一个真实存在的pid,否则会失败.如果被伪装的进程关闭了，那么当前进程也会立刻失去伪装. 还有最重要的一点，伪装的进程和目的进程，占用内存要差不多，最好目的进程占用内存要大于被伪装进程，否则可能会导致进程崩溃!!!  有些编译平台编译出的程序,貌似开这个盾会导致异常，可以尝试f2盾.

★ "d1 [cls][add dll_name exact]" : 阻止指定的dll加载到本进程.这里的dll_name不区分大小写. 具体调用方法看下面的例子.

★ "f2 <target_process> <protect_process>" :把protect_process伪装成target_process运行. 此盾会加载target_process运行,然后用protect_process来替换target_process,从而达到伪装自身的目的.此盾不加载驱动 (使用此盾后，别人无法获取到你的进程的真实路径，但自己也同样无法获取，所以如果要获取真实路径，请务必在获取到路径后保存后,通过共享内存等方式传递给保护进程). 返回值为伪装后的进程ID

"phide [pid]" : 隐藏指定进程,保护指定进程以及进程内的窗口不被非法访问. pid为可选参数.如果不指定pid，默认保护当前进程.(此模式需要加载驱动,普通版本仅支持32位系统)
"phide2 [pid]" : 同phide. 只是进程不隐藏(可在任务管理器中操作) (此模式需要加载驱动,普通版本仅支持32位系统)
"phide3 [pid]" : 只隐藏进程(在任务管理器看不到),但不保护进程和窗口. (此模式需要加载驱动,普通版本仅支持32位系统)

"hm module unlink" : 防止当前进程中的指定模块被非法访问. module为模块名(为0表示EXE模块),比如dm.dll 。 unlink取0或者1，1表示是否把模块在进程模块链表中擦除,0表示不擦除.(此模式需要加载驱动)

"inject mode <param> pid unlink erase" : 注入指定的DLL到指定的进程中. 具体参数含义根据mode决定.(此模式需要加载驱动)
mode取值0 1 2 3，具体含义如下:
0: 此时param表示需要注入的dll全路径. pid表示需要注入进去的进程ID. unlink(取值0和1)，表示是否从进程模块链表中断链. erase(取值0和1),表示是否擦除PE头. 注入方式是通过创建线程注入.
1: 此时param表示需要注入的dll全路径. pid表示需要注入进去的进程ID. unlink(取值0和1)，表示是否从进程模块链表中断链. erase(取值0和1),表示是否擦除PE头. 注入方式是通过APC注入.
2: 此时param表示需要注入的dll全路径. pid表示需要注入进去的进程ID. unlink(取值0和1)，表示是否从进程模块链表中断链. erase(取值0和1),表示是否擦除PE头. 注入方式是内存加载DLL.
3: 此时param表示需要注入的dll的地址和大小. param表示为addr,size. addr表示DLL的起始地址,10进制表示,size表示DLL的大小，10进制表示. pid表示需要注入进去的进程ID. unlink(取值0和1)，表示是否从进程模块链表中断链. erase(取值0和1),表示是否擦除PE头. 注入方式是内存加载DLL.

"del <path>" :强制删除指定的文件. path表示需要删除的文件的全路径. 当path为0时,表示为当前dm.dll的路径,当path为1时,表示为当前EXE的全路径.(此模式需要加载驱动)
其它后续开发.

            "★ cl pid type name": 关闭指定进程中，对象名字中含有name的句柄. pid表示进程PID. type表示需要关闭的句柄类型. 比如Section Event Mutant等. 具体的类型可以用pchunter查看.
        name表示需要查找的对象名. 注意type和name都是大小写敏感的.

返回值:

整形数:
0 : 不支持的保护盾类型
1 : 成功
-1 : 32位平台不支持
-2 : 驱动释放失败.(可能原因是权限不够)
-3 : 驱动加载失败,可能是权限不够. 参考UAC权限设置.或者是被安全软件拦截. 如果是在64位系统下返回此错误，需要安装补丁KB3033929.

如果是WIN10 1607之后的系统，出现这个错误，可参考这里
-555 : f2盾的返回值, protect_process路径无法访问.
-666 : f2盾的返回值, target_process无法创建进程.(可能路径错误?)
-777 : f2盾的返回值,其它异常错误.
-4 -5 -6 -8都是异常错误.
-7: 一般是系统版不支持导致,用winver可以查看系统内部版本号. 驱动只支持正式发布的版本，所有预览版本都不支持.
-9 : 表示参数错误.
-10 : 表示此盾的功能失败了.
-11 : 表示分配内存失败.
-14 : 无效的窗口句柄

示例:

dm.DmGuard 1,"np"
dm.DmGuard 1,"memory"
dm.DmGuard 1,"display2"
dm.DmGuard 1,"block"
dm.DmGuard 1,"block 1044"
dm.DmGuard 1,"b2"
dm.DmGuard 1,"b2 1044"
dm.DmGuard 0,"b2"
dm.DmGuard 1,"f1"
dm.DmGuard 1,"f1 2358"
dm.DmGuard 1,"f2 <c:\windows\system32\calc.exe> <d:\test\my.exe>"
dm.DmGuard 1,"f2 <d:\test\my_cheate.exe> <d:\test\my.exe>"
dm.DmGuard 1,"f2 <d:\test\aaa.dat> <d:\test\my.exe>"
dm.DmGuard 1,"b3"
dm.DmGuard 1,"b3 1044"
dm.DmGuard 0,"b3"
dm.DmGuard 1,"memory2"
dm.DmGuard 1,"memory3 1044"
dm.DmGuard 1,"hm dm.dll 1"
dm.DmGuard 1,"hm dm.dll 0"
// 这个是隐藏exe模块
dm.DmGuard 1,"hm 0 1"
dm.DmGuard 1,"hm xxx.dll 1"
dm.DmGuard 1,"inject 0 <c:\test.dll> 1044 1 1"
dm.DmGuard 1,"inject 1 <c:\test.dll> 1044 1 0"
dm.DmGuard 1,"inject 2 <c:\test.dll> 1044 1 1"
dm.DmGuard 1,"inject 3 <239458,568> 1044 1 1"
dm.DmGuard 1,"del <c:\test.dll>"
dm.DmGuard 1,"del <0>
dm.DmGuard 1,"del <1>"
dm.DmGuard 1,"display3 1188"
dm.DmGuard 0,"display3 1188"
// 关闭进程1024中,类型为Mutant的，名字中含有test123的句柄.
dm.DmGuard 1,"cl 1024 Mutant test123"
// 关闭进程1024中,类型为Event的，名字中含有abc的句柄.
dm.DmGuard 1,"cl 1024 Event abc"

// 清除拦截列表
dm.DmGuard 1,"d1 cls"
// 拦截dll名字中含有antiphinshing的所有dll
dm.DmGuard 1,"d1 add antiphinshing 0"
// 拦截dll名字完全等同于abc.dll的DLL加载
dm.DmGuard 1,"d1 add abc.dll 1"
// 拦截所有DLL的加载
dm.DmGuard 1,"d1 add all"

注 : 此函数最好在目标进程打开之前调用即可。调用一次即可。尽量保证此函数第一个被执行，以免和其他驱动冲突.此函数最好在绑定之前执行.
可多个组合调用.
另外np和display2盾有点特殊,必须保证调用此对象的dm对象一直处于存在状态,不可以释放. 一旦释放,等于没调用.比如有些人喜欢在按键的OnScriptLoad中调用这2个盾,实际上OnScriptLoad执行完以后,对象会自动被释放掉.
f2盾特别注意, protect_process为你的真正需要运行的程序, target_process为任意一个可执行的exe,最后protect_process被伪装成target_process运行. 但由于兼容性问题, target_process的选取并不是任意的,请自己做好测试. 有些target_process会出现让你的程序UI不太正常等异常问题. 经过我测试,最好是使用自己平台编译出的exe最好. 当然,如果你使用系统exe或者其它EXE，只要测试没问题，也是OK的. 另外,这2个EXE必须都是32位的,否则会加载失败!   调用此盾的程序相当于是个EXE加载器,加载成功后,自己就可以退出了.
f2盾使用至少需要3个EXE, A B C,其中A是加载器，里面执行f2盾,B是被伪装成的程序，C是你的真正的程序. A执行f2盾类似这样,DmGuard 1,"f2 B C"
f2盾有个限制，如果C是使用f2启动的，那么C里面会无法加载驱动。比如我的DmGuard函数在C中会失败. 解决办法是所有在C中需要加载的盾，都必须在A里面也加载一次。


另外4个memory盾是可以切换的,切换方式是重新调用另一个memory盾即可,只有最后调用的memory盾生效.

盾都要求在目标进程开启之前开启,但memory3比较特殊,因为他必须接一个真实存在的pid。 对于这种情况，只需要提前加载memory2,等目标进程打开以后，再调用memory3即可.



4个memory盾在相同接口下的速度如下 memory3>memory4>memory>memory2
4个memory盾突破防护的能力如下 memory2>memory3>memory4>memory
另外,如果您需要极限读写速度,请使用带Addr系列的读写接口,比相同系列不带Addr的接口速度要快30%.
如果您要使用memory系列盾,请让它第一个被加载,这样可以让效率最大化.



display3盾仅仅支持win7以上系统. 并且系统必须开启了DWM. 否则会返回失败. win10以下的系统可以手动设置DWM的开关,win10以上的系统是强制打开的,无法关闭.
所以此盾在win10系统上效果很好.  下图是win7如何打开DWM,也就是说只要勾选了启用桌面组合和在窗口和按钮上使用视觉样式就会开启dwm. win8应该也是类似.


如果您开启了dwm，并且调用成功了display3盾后,如果中途关闭了dwm,那么保护就会失效. 另外此盾只能保护当前进程的窗口.

二、  窗口绑定说明

函数简介:

绑定指定的窗口,并指定这个窗口的屏幕颜色获取方式,鼠标仿真模式,键盘仿真模式 高级用户使用.

函数原型:

long BindWindowEx(hwnd,display,mouse,keypad,public,mode)

参数定义:

hwnd 整形数: 指定的窗口句柄

display 字符串: 屏幕颜色获取方式 取值有以下几种

"normal" : 正常模式,平常我们用的前台截屏模式

"gdi" : gdi模式,用于窗口采用GDI方式刷新时. 此模式占用CPU较大. 参考SetAero. win10以上系统使用此模式，如果截图失败，尝试把目标程序重新开启再试试。

"gdi2" : gdi2模式,此模式兼容性较强,但是速度比gdi模式要慢许多,如果gdi模式发现后台不刷新时,可以考虑用gdi2模式.

"dx2" : dx2模式,用于窗口采用dx模式刷新,如果dx方式会出现窗口进程崩溃的状况,可以考虑采用这种.采用这种方式要保证窗口有一部分在屏幕外.win7 win8或者vista不需要移动也可后台. 此模式占用CPU较大. 参考SetAero. win10以上系统使用此模式，如果截图失败，尝试把目标程序重新开启再试试。

"dx3" : dx3模式,同dx2模式,但是如果发现有些窗口后台不刷新时,可以考虑用dx3模式,此模式比dx2模式慢许多. 此模式占用CPU较大. 参考SetAero. win10以上系统使用此模式，如果截图失败，尝试把目标程序重新开启再试试。

dx模式,用于窗口采用dx模式刷新,取值可以是以下任意组合，组合采用"|"符号进行连接. 支持BindWindow中的缩写模式. 比如dx代表" dx.graphic.2d| dx.graphic.3d"
1. "dx.graphic.2d"  2d窗口的dx图色模式
2. "dx.graphic.2d.2"  2d窗口的dx图色模式  是dx.graphic.2d的增强模式.兼容性更好.
3. "dx.graphic.3d"  3d窗口的dx图色模式,
4. "dx.graphic.3d.8"  3d窗口的dx8图色模式,  此模式对64位进程无效.
5. "dx.graphic.opengl"  3d窗口的opengl图色模式,极少数窗口采用opengl引擎刷新. 此图色模式速度可能较慢.
6. "dx.graphic.opengl.esv2"  3d窗口的opengl_esv2图色模式,极少数窗口采用opengl引擎刷新. 此图色模式速度可能较慢.
7. "dx.graphic.3d.10plus"  3d窗口的dx10 dx11图色模式


mouse 字符串: 鼠标仿真模式 取值有以下几种

"normal" : 正常模式,平常我们用的前台鼠标模式

"windows": Windows模式,采取模拟windows消息方式 同按键的后台插件.

"windows3": Windows3模式，采取模拟windows消息方式,可以支持有多个子窗口的窗口后台

dx模式,取值可以是以下任意组合. 组合采用"|"符号进行连接. 支持BindWindow中的缩写模式,比如windows2代表"dx.mouse.position.lock.api|dx.mouse.position.lock.message|dx.mouse.state.message"
1. "dx.mouse.position.lock.api"  此模式表示通过封锁系统API，来锁定鼠标位置.
2. "dx.mouse.position.lock.message" 此模式表示通过封锁系统消息，来锁定鼠标位置.
3. "dx.mouse.focus.input.api" 此模式表示通过封锁系统API来锁定鼠标输入焦点.
4. "dx.mouse.focus.input.message"此模式表示通过封锁系统消息来锁定鼠标输入焦点.
5. "dx.mouse.clip.lock.api" 此模式表示通过封锁系统API来锁定刷新区域。注意，使用这个模式，在绑定前，必须要让窗口完全显示出来.
6. "dx.mouse.input.lock.api" 此模式表示通过封锁系统API来锁定鼠标输入接口.
7. "dx.mouse.state.api" 此模式表示通过封锁系统API来锁定鼠标输入状态.
8. "dx.mouse.state.message" 此模式表示通过封锁系统消息来锁定鼠标输入状态.
9. "dx.mouse.api"  此模式表示通过封锁系统API来模拟dx鼠标输入.
10. "dx.mouse.cursor"  开启此模式，可以后台获取鼠标特征码.
11. "dx.mouse.raw.input"  有些窗口需要这个才可以正常操作鼠标.
12. "dx.mouse.input.lock.api2"  部分窗口在后台操作时，前台鼠标会移动,需要这个属性.
13. "dx.mouse.input.lock.api3"  部分窗口在后台操作时，前台鼠标会移动,需要这个属性.


keypad 字符串: 键盘仿真模式 取值有以下几种

"normal" : 正常模式,平常我们用的前台键盘模式

"windows": Windows模式,采取模拟windows消息方式 同按键的后台插件.

dx模式,取值可以是以下任意组合. 组合采用"|"符号进行连接. 支持BindWindow中的缩写模式.比如dx代表" dx.public.active.api|dx.public.active.message| dx.keypad.state.api|dx.keypad.api|dx.keypad.input.lock.api"
1. "dx.keypad.input.lock.api" 此模式表示通过封锁系统API来锁定键盘输入接口.
2. "dx.keypad.state.api" 此模式表示通过封锁系统API来锁定键盘输入状态.
3. "dx.keypad.api" 此模式表示通过封锁系统API来模拟dx键盘输入.
4. "dx.keypad.raw.input"  有些窗口需要这个才可以正常操作键盘.



public 字符串: 公共属性 dx模式共有

取值可以是以下任意组合. 组合采用"|"符号进行连接 这个值可以为空
1. "dx.public.active.api" 此模式表示通过封锁系统API来锁定窗口激活状态.  注意，部分窗口在此模式下会耗费大量资源慎用.
2. "dx.public.active.message" 此模式表示通过封锁系统消息来锁定窗口激活状态.  注意，部分窗口在此模式下会耗费大量资源慎用. 另外如果要让此模式生效，必须在绑定前，让绑定窗口处于激活状态,否则此模式将失效. 比如dm.SetWindowState hwnd,1 然后再绑定.
3.  "dx.public.disable.window.position" 此模式将锁定绑定窗口位置.不可与"dx.public.fake.window.min"共用.
4.  "dx.public.disable.window.size" 此模式将锁定绑定窗口,禁止改变大小. 不可与"dx.public.fake.window.min"共用.
5.  "dx.public.disable.window.minmax" 此模式将禁止窗口最大化和最小化,但是付出的代价是窗口同时也会被置顶. 不可与"dx.public.fake.window.min"共用.
6.  "dx.public.fake.window.min" 此模式将允许目标窗口在最小化状态时，仍然能够像非最小化一样操作.. 另注意，此模式会导致任务栏顺序重排，所以如果是多开模式下，会看起来比较混乱，建议单开使用，多开不建议使用. 同时此模式不是万能的,有些情况下最小化以后图色会不刷新或者黑屏.
7.  "dx.public.hide.dll" 此模式将会隐藏目标进程的大漠插件，避免被检测..另外使用此模式前，请仔细做过测试，此模式可能会造成目标进程不稳定，出现崩溃。
8.  "dx.public.active.api2" 此模式表示通过封锁系统API来锁定窗口激活状态. 部分窗口遮挡无法后台,需要这个属性.
9.  "dx.public.input.ime" 此模式是配合SendStringIme使用. 具体可以查看SendStringIme接口.
    10  "dx.public.graphic.protect" 此模式可以保护dx图色不被恶意检测.同时对dx.keypad.api和dx.mouse.api也有保护效果.
    11  "dx.public.disable.window.show" 禁止目标窗口显示,这个一般用来配合dx.public.fake.window.min来使用.
    12  "dx.public.anti.api" 此模式可以突破部分窗口对后台的保护.
    13  "dx.public.km.protect" 此模式可以保护dx键鼠不被恶意检测.最好配合dx.public.anti.api一起使用. 此属性可能会导致部分后台功能失效.
    14   "dx.public.prevent.block"  绑定模式1 3 5 7 101 103下，可能会导致部分窗口卡死. 这个属性可以避免卡死.
    15   "dx.public.ori.proc"  此属性只能用在模式0 1 2 3和101下. 有些窗口在不同的界面下(比如登录界面和登录进以后的界面)，键鼠的控制效果不相同. 那可以用这个属性来尝试让保持一致. 注意的是，这个属性不可以滥用，确保测试无问题才可以使用. 否则可能会导致后台失效.
    16  "dx.public.down.cpu" 此模式可以配合DownCpu来降低目标进程CPU占用.  当图色方式降低CPU无效时，可以尝试此种方式.
    17  "dx.public.focus.message" 当后台绑定后,后台无法正常在焦点窗口输入文字时,可以尝试加入此属性. 此属性会强制键盘消息发送到焦点窗口. 慎用此模式,此模式有可能会导致后台键盘在某些情况下失灵.
    18  "dx.public.graphic.speed" 只针对图色中的dx模式有效.此模式会牺牲目标窗口的性能，来提高DX图色速度，尤其是目标窗口刷新很慢时，这个参数就很有用了.
    19  "dx.public.memory" 让本对象突破目标进程防护,可以正常使用内存接口. 当用此方式使用内存接口时，内存接口的速度会取决于目标窗口的刷新率.
    20  "dx.public.inject.super" 突破某些难以绑定的窗口. 此属性仅对除了模式0和2的其他模式有效.
    21  "dx.public.hack.speed" 类似变速齿轮，配合接口HackSpeed使用



mode 整形数: 模式。取值有以下几种

     0 : 推荐模式此模式比较通用，而且后台效果是最好的.

     2 : 同模式0,如果模式0有崩溃问题，可以尝试此模式.  注意0和2模式，当主绑定(第一个绑定同个窗口的对象)绑定成功后，那么调用主绑定的线程必须一致维持,否则线程一旦推出,对应的绑定也会消失.

     101 : 超级绑定模式. 可隐藏目标进程中的dm.dll.避免被恶意检测.效果要比dx.public.hide.dll好. 推荐使用.

     103 : 同模式101，如果模式101有崩溃问题，可以尝试此模式.

     11 : 需要加载驱动,适合一些特殊的窗口,如果前面的无法绑定，可以尝试此模式. 此模式不支持32位系统

     13 : 需要加载驱动,适合一些特殊的窗口,如果前面的无法绑定，可以尝试此模式. 此模式不支持32位系统

需要注意的是: 模式101 103在大部分窗口下绑定都没问题。但也有少数特殊的窗口，比如有很多子窗口的窗口，对于这种窗口，在绑定时，一定要把鼠标指向一个可以输入文字的窗口，比如一个文本框，最好能激活这个文本框，这样可以保证绑定的成功.

返回值:

整形数:
0: 失败
1: 成功

如果返回0，可以调用GetLastError来查看具体失败错误码,帮助分析问题.

示例:


比如
dm_ret = dm.BindWindowEx(hwnd,"normal","dx.mouse.position.lock.api|dx.mouse.position.lock.message","windows","dx.public.active.api",0)



dm_ret = dm.BindWindowEx(hwnd,"dx2","windows","normal","dx.public.active.api",0)



dm_ret = dm.BindWindowEx(hwnd,"dx.graphic.2d","dx.mouse.position.lock.api|dx.mouse.position.lock.message","dx.keypad.state.api|dx.keypad.api","",0)



dm_ret = dm.BindWindowEx(hwnd,"dx2","windows","windows","",0)


dm_ret = dm.BindWindowEx(hwnd,"dx2","windows","windows","dx.public.disable.window.size|dx.public.disable.window.minmax",0)



dm_ret = dm.BindWindowEx(hwnd,"dx2","windows3","windows","dx.mouse.position.lock.api",0)

等等.


注意:


绑定之后,所有的坐标都相对于窗口的客户区坐标(不包含窗口边框)
另外,绑定窗口后,必须加以下代码,以保证所有资源正常释放

这个函数的意思是在脚本结束时,会调用这个函数。需要注意的是，目前的按键版本对于这个函数的执行不是线程级别的，也就是说，这个函数只会在主线程执行，子线程绑定的大漠对象，不保证完全释放。高级语言中则需要自己控制在适当的时候解除绑定.
Sub OnScriptExit()
dm_ret = dm.UnBindWindow()
End Sub

另外 绑定dx会比较耗时间,请不要频繁调用此函数.

还有一点特别要注意的是,有些窗口绑定之后必须加一定的延时,否则后台也无效.一般1秒到2秒的延时就足够.



发现绑定失败的几种可能(一般是需要管理员权限的模式才有可能会失败)

1.     系统登录的帐号必须有Administrators权限

2.     一些防火墙会防止插件注入窗口所在进程，比如360防火墙等，必须把dm.dll设置为信任.

3.     还有一个比较弱智的可能性，那就是插件没有注册到系统中，这时CreateObject压根就是失败的. 检测对象是否创建成功很简单，如下代码

set dm = createobject("dm.dmsoft")
ver = dm.Ver()
If len(ver) = 0 Then
MessageBox "创建对象失败,检查系统是否禁用了vbs脚本权限"
EndScript
End If

4.     在沙盘中开的窗口，绑定一些需要管理员权限的模式，会失败。
解决方法是要配置沙盘参数，参考如何配置沙盘参数.



5.     窗口所在进程有保护，这个我也无能为力.

三、  其他说明

使用前电脑必须安装好大漠插件,不会安装的自行百度,大部分函数是免费使用的(少数函数是大漠插件开发者收费,不是我本人),我就不过多介绍了。


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
