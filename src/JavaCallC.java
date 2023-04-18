public class JavaCallC { //如果用了public，类名和源文件名必须一致
    static { //加载动态库，不用加扩展名，windows下会加载testJni.dll，linux下会加载testJni.so
        System.loadLibrary("CtoJava"); //这就是dll名字，要和vs创建的项目名一致。
    }
    public static native void keyboardBlockerOn();
    public static native void keyboardBlockerOff();//native声明一个本地接口，函数名任取，不用和包名，类名相同。
}