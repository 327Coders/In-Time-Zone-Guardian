full_command_line := DllCall("GetCommandLine", "str")

if not (A_IsAdmin or RegExMatch(full_command_line, " /restart(?!\S)"))
{
    try
    {
        if A_IsCompiled
            Run '*RunAs "' A_ScriptFullPath '" /restart'
        else
            Run '*RunAs "' A_AhkPath '" /restart "' A_ScriptFullPath '"'
    }
    ExitApp
}

guititle := "TimeGuardian"
Main := Gui("-SysMenu", "TimeGuardian")
Main.MenuBar := ""
Main.Add("Text",, "计时器:")

Main.Add("Text",, "  工作时间:")
Main.Add("Text",, "  休息时间:")

Main.Add("Text",, "选项:")
Main.Add("CheckBox", "Checked xm+10 vDefaultCheckBox", "休息时屏蔽键盘和鼠标")

Main.Add("Button", "Center", "开始").OnEvent("Click", ProcessUserInput)

Main.Add("Text", "ym+4 xm+80")
Main.Add("Edit", " w50 vWorkTime") 
Main.Add("UpDown", "vWorkTimeUpDown Range1-60", 30)
Main.Add("Edit", "w50 vRestTime")
Main.Add("UpDown", "vRestTimeUpDown Range1-20", 5)


Main.Add("Text", "ym xm+140")
Main.Add("Text",, "(分钟)")
Main.Add("Text",, "(分钟)")
Main.Show()

workTime := ""
restTime := ""
Saved := ""
status := 1
time := ""
daojishi := ""
ProcessUserInput(*)
{
    global Saved 
    global Main
    global status
    global workTime
    global restTime
    Saved := Main.Submit()
    workTime := Saved.WorkTimeUpDown * 60
    restTime := Saved.RestTimeUpDown * 60
    Main.Destroy()
    while(true){
        if(status == 1)
            work()
        else
            rest()
    }
}     

!c::ProcessClose(guititle ".exe")
!b::{
    global time,Main,status,workTime,restTime

    if(status == 1)
        ; work()
        time := workTime + 1
    else
        ; rest()
        time := restTime + 1

    Sleep 1100

}



work(){
    global workTime,status,daojishi,Main

    tipGui("cffffff s20 w100", "w250 h45 Center yp+15", "注意坐姿")
    daojishi := Main.Add("Text", "w250 h40 Center yp+50 xp+30", Format("{:02}", Round(workTime / 60)) ":" Format("{:02}", 0))
    Main.Show("W250 H120 X" SysGet(78) * 0.88 " Y" SysGet(79) * 0.82)
    BlockInput "Off"
    timeRest()
    status := 0
}


rest(){
    global restTime,status,daojishi,Main,guititle

    tipGui("cFFFFFF s30 w100", "w" SysGet(78) " Center ym" SysGet(79) / 2 - 100 " " "h100", "您已工作" Round(restTime / 60) "分钟，请站起来活动一下吧！")
    daojishi := Main.Add("Text", "w" SysGet(78) " Center h100", Format("{:02}", Round(restTime / 60)) ":" Format("{:02}", 0))
    Main.Show("X0 Y0 W" SysGet(78) " H" SysGet(79))
    BlockInput "On"

    WinSetTransparent 180, guititle

    timeRest()
    status := 1
}


tipGui(fontFormat, textOption, tipText){
    global guititle,Main
    Main := Gui("AlwaysOnTop -DPIScale -SysMenu" ,guititle)
    Main.MenuBar := ""
    Main.MarginX := 0
    Main.SetFont(fontFormat)
    Main.BackColor := "066c06"
    Main.Add("Text", textOption, tipText)
}

timeRest(){
    global status,workTime,restTime,time,Main

    if(status == 1){
        time := workTime + 1
    }
    else{
        time := restTime + 1
    }
    SetTimer xianshi, 1000
    while(time){
        Sleep 500
    }
    SetTimer xianshi, 0
    Main.Destroy()
}

xianshi(){
    global time,daojishi,Main
    if(time == 0){
        SetTimer xianshi, 0
        Main.Destroy()
    }else{
        time--
        daojishi.Text := Format("{:02}", Floor(time / 60)) ":" Format("{:02}", Mod(time, 60))
    }
    
}
    
