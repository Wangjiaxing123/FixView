# FixView
[![](https://www.jitpack.io/v/Wangjiaxing123/FixView.svg)](https://www.jitpack.io/#Wangjiaxing123/FixView)
能设置前缀或后缀的TextView或EditText

## 添加方式
step1 Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

step2 Add the dependency
```gradle
dependencies {
	        compile 'com.github.Wangjiaxing123:FixView:release_version'
	}
```

## 使用方法
```xml
  <com.newtrekwang.fixviewlib.edite.FixEditText
      android:layout_width="match_parent"
      android:id="@+id/fixEt"
      app:fix_text="密码"
      app:hint_text="请输入密码"
      app:preOrPost="PREFIX"
      android:layout_height="50dp"/>
```
## preOrPost="PREFIX" 前缀
![](http://ojgs96t5i.bkt.clouddn.com/screenshot-1524487193143.jpg)
## preOrPost="POSTFIX" 后缀
![](http://ojgs96t5i.bkt.clouddn.com/screenshot-1524487369064.jpg)