"""
本代码由[Tkinter布局助手]生成
当前版本:3.2.3
官网:https://www.pytk.net/tkinter-helper
QQ交流群:788392508
"""
from tkinter import *
from tkinter import messagebox
from tkinter.ttk import *
import tkinter.font as tf


class MainWin(Tk):
    '''
        设置的主窗口
    '''
    widget_dic = dict()

    def __init__(self, work=None, relax=None):
        '''
        默认启动时不带参数，从配置文件读取，当由Popup窗口和Lock窗口创建时传入它们自己的时间参数
        :param work: 工作时间(分钟)
        :param relax: 休息时间(分钟)
        '''
        super().__init__()
        self.__win()
        self.widget_dic["tk_label_timer"] = self.__tk_label_timer(self)
        self.widget_dic["tk_label_worktime"] = self.__tk_label_worktime(self)
        self.widget_dic["tk_label_relaxtime"] = self.__tk_label_relaxtime(self)
        self.widget_dic["tk_input_worktime"] = self.__tk_input_worktime(self)
        self.widget_dic["tk_input_relaxtime"] = self.__tk_input_relaxtime(self)
        self.widget_dic["tk_label_option"] = self.__tk_label_option(self)
        self.widget_dic["tk_check_button_ban"] = self.__tk_check_button_ban(self)
        self.widget_dic["tk_button_start"] = self.__tk_button_start(self)
        self.widget_dic["tk_label_min"] = self.__tk_label_min(self)
        self.widget_dic["tk_label_min2"] = self.__tk_label_min2(self)

        # TODO config 读取配置文件初始化时间参数
        # TODO config 如果没有读取到配置文件则生成一个
        # 当默认启动时，参数由配置文件读取
        if work is None:
            self.widget_dic["tk_input_worktime"].insert('0', '25')
        else:
            self.widget_dic["tk_input_worktime"].insert('0', f"{work}")
        if relax is None:
            self.widget_dic["tk_input_relaxtime"].insert('0', '5')
        else:
            self.widget_dic["tk_input_relaxtime"].insert('0', f"{relax}")

    def __win(self):
        self.title("InTime")
        # 设置窗口大小、居中
        width = 217
        height = 232
        screenwidth = self.winfo_screenwidth()
        screenheight = self.winfo_screenheight()
        geometry = '%dx%d+%d+%d' % (width, height, (screenwidth - width) / 2, (screenheight - height) / 2)
        self.geometry(geometry)
        self.resizable(width=False, height=False)
        self.attributes("-toolwindow", 2)
        self.attributes('-topmost', 'true')

    def __tk_label_timer(self, parent):
        label = Label(parent, text="计时器：", anchor="center")
        label.place(x=20, y=20, width=50, height=30)
        return label

    def __tk_label_worktime(self, parent):
        label = Label(parent, text="工作时间：", anchor="center")
        label.place(x=40, y=51, width=63, height=30)
        return label

    def __tk_label_relaxtime(self, parent):
        label = Label(parent, text="休息时间：", anchor="center")
        label.place(x=40, y=82, width=63, height=30)
        return label

    def __tk_input_worktime(self, parent):
        ipt = Entry(parent)
        ipt.place(x=104, y=57, width=50, height=20)
        return ipt

    def __tk_input_relaxtime(self, parent):
        ipt = Entry(parent)
        ipt.place(x=104, y=89, width=50, height=20)
        return ipt

    def __tk_label_option(self, parent):
        label = Label(parent, text="选项：", anchor="center")
        label.place(x=20, y=120, width=50, height=30)
        return label

    def __tk_check_button_ban(self, parent):
        cb = Checkbutton(parent, text="屏蔽键盘和鼠标")
        cb.place(x=40, y=150, width=139, height=30)
        return cb

    def __tk_button_start(self, parent):
        btn = Button(parent, text="开始")
        btn.place(x=80, y=182, width=50, height=30)
        return btn

    def __tk_label_min(self, parent):
        label = Label(parent, text="(分钟)", anchor="center")
        label.place(x=155, y=51, width=38, height=30)
        return label

    def __tk_label_min2(self, parent):
        label = Label(parent, text="(分钟)", anchor="center")
        label.place(x=155, y=82, width=38, height=30)
        return label


class LMainWin(MainWin):
    def __init__(self, work=None, relax=None):
        super().__init__(work, relax)
        self.__event_bind()

    def startwork(self, evt):
        '''
        启动工作模式，使用输入框里的时间参数
        :param evt:
        :return:
        '''
        worktime = self.widget_dic['tk_input_worktime'].get()
        relaxtime = self.widget_dic['tk_input_relaxtime'].get()
        # messagebox.showinfo(title='温馨提示', message=worktime)
        popup = Popup(int(worktime), int(relaxtime))
        self.destroy()
        popup.mainloop()

    # 锁定键盘的功能暂不实现
    def check_ban(self, evt):
        pass
        # print("<Button>事件未处理", evt)

    def __event_bind(self):
        # self.widget_dic["tk_check_button_ban"].bind('<Button>', self.check_ban)
        self.widget_dic["tk_button_start"].bind('<Button>', self.startwork)


class LockUI(Tk):
    widget_dic = dict()

    def __init__(self):
        super().__init__()
        self.__win()
        self.widget_dic["tk_label_tip"] = self.__tk_label_tip(self)
        self.widget_dic["tk_label_time"] = self.__tk_label_time(self)

    def __win(self):
        self.attributes('-topmost', 'true')
        self.attributes("-alpha", 0.8)
        self.overrideredirect(True)
        # 设置窗口大小、居中
        width = 148
        height = 55
        screenwidth = self.winfo_screenwidth()
        screenheight = self.winfo_screenheight()
        geometry = '%dx%d' % (screenwidth, screenheight)
        self.geometry(geometry)
        self.resizable(width=False, height=False)
        self.config(background='green')
        # self.attributes("-fullscreen")

    def __tk_label_tip(self, parent):
        ft = tf.Font(family='楷书', size=14)
        label = Label(parent, text="您已久坐，键盘和鼠标被锁定，站起来活动下！", anchor="center", font=ft,
                      background='green', foreground='white')
        xx = self.winfo_screenwidth() / 2 - 500
        yy = self.winfo_screenheight() / 2 - 15
        label.place(x=xx, y=yy, width=1000, height=30)
        return label

    def __tk_label_time(self, parent):
        ft = tf.Font(family='楷书', size=14)
        label = Label(parent, text="解锁倒计时", anchor="center", font=ft, background='green', foreground='white')
        xx = self.winfo_screenwidth() / 2 - 500
        yy = self.winfo_screenheight() / 2 + 15
        label.place(x=xx, y=yy, width=1000, height=30)
        return label


class Lock(LockUI):
    def __init__(self, work, relax):
        super().__init__()
        # TODO config 配置文件可改背景图片
        self.work = work
        self.relax = relax
        self.time = relax * 60
        self.widget_dic["tk_label_tip"].config(text=f"您已久坐{self.work}分钟了，键盘和鼠标被锁定，站起来活动下！")
        self.showtime()
        self.__event_bind()

    def showtime(self):
        # 休息结束后重新开始工作
        if self.time == 0:
            popup = Popup(self.work, self.relax)
            self.destroy()
            popup.mainloop()

        # 刷新时间
        minutes = int(self.time / 60)
        seconds = int(self.time % 60)
        self.time -= 1
        string = "解锁倒计时：{:0>2d}:{:0>2d}".format(minutes, seconds)
        self.widget_dic["tk_label_time"].config(text=string)
        # 每隔 1秒钟执行time函数
        self.widget_dic["tk_label_time"].after(1000, self.showtime)

    def __event_bind(self):
        # TODO 快捷键重置工作计时
        pass


class PopupUI(Tk):
    widget_dic = dict()

    def __init__(self):
        super().__init__()
        self.__win()
        self.widget_dic["tk_label_tip"] = self.__tk_label_tip(self)
        self.widget_dic["tk_label_time"] = self.__tk_label_time(self)

    def __win(self):
        # self.title("InTime")
        # self.attributes("-alpha", 0.8)
        self.attributes('-topmost', 'true')
        self.overrideredirect(True)
        # 设置窗口大小、居中
        width = 148
        height = 55
        screenwidth = self.winfo_screenwidth()
        screenheight = self.winfo_screenheight()
        # TODO config 窗口的位置被拖动之后记录下来 从这里加载
        geometry = '%dx%d+%d+%d' % (width, height, screenwidth - width * 2, screenheight - height * 2)
        self.geometry(geometry)
        self.resizable(width=False, height=False)
        self.config(background='green')
        # 自动隐藏滚动条

    def __tk_label_tip(self, parent):
        ft = tf.Font(family='楷书', size=14)
        label = Label(parent, text="注意坐姿", anchor="center", font=ft, background='green', foreground='white')
        label.place(x=25, y=0, width=100, height=25)
        return label

    def __tk_label_time(self, parent):
        ft = tf.Font(family='楷书', size=14)
        label = Label(parent, text="工作时间", anchor="center", font=ft, background='green', foreground='white')
        label.place(x=25, y=30, width=100, height=25)
        return label


class Popup(PopupUI):
    '''
        倒计时界面， 需要传入工作和休息时间 单位 分钟
    '''

    def __init__(self, work, relax):
        super().__init__()
        self.__menu()
        self.work = work
        self.relax = relax
        self.time = work * 60
        self.showtime()
        self.__event_bind()

    def __menu(self):
        self.menu = Menu(self, tearoff=False)
        self.menu.add_command(label='首选项', command=self.show_main)
        self.menu.add_command(label='重置计时', command=self.reset)
        self.menu.add_command(label='退出', command=self.destroy)

    def show_main(self):
        self.destroy()
        main_win = LMainWin(self.work, self.relax)
        main_win.mainloop()

    def reset(self):
        self.destroy()
        popup = Popup(int(self.work), int(self.relax))
        popup.mainloop()

    def showtime(self):
        # 剩余工作时间不足15s时变成红色
        if self.time < 15:
            self.config(background='red')
            self.widget_dic["tk_label_tip"].config(background='red')
            self.widget_dic["tk_label_time"].config(background='red')

        # 工作时间结束 启动锁屏界面并销毁计时窗口
        if self.time == 0:
            lock = Lock(self.work, self.relax)
            self.destroy()
            lock.mainloop()

        # 刷新计时
        minutes = int(self.time / 60)
        seconds = int(self.time % 60)
        self.time -= 1
        string = "{:0>2d}:{:0>2d}".format(minutes, seconds)
        self.widget_dic["tk_label_time"].config(text=string)
        # 每隔 1秒钟执行time函数
        self.widget_dic["tk_label_time"].after(1000, self.showtime)

    # TODO config 拖动之后 保存计时器的窗口位置，下次直接加载
    def mousedown(self, evt):
        self.mousX = evt.x
        self.mousY = evt.y

    def mousemove(self, evt):
        self.geometry(f'+{evt.x_root - self.mousX}+{evt.y_root - self.mousY}')

    def menu_pop(self, evt):
        self.menu.post(evt.x + self.winfo_rootx(), evt.y + self.winfo_rooty())
        self.update()

    def __event_bind(self):
        self.bind("<Button-1>", self.mousedown)
        self.bind("<B1-Motion>", self.mousemove)
        self.bind("<Button-3>", self.menu_pop)
        # TODO 快捷键重置工作计时
        pass


win = LMainWin()
win.mainloop()
