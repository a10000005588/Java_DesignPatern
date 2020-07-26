public class main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // 定義出兩種房間的燈
        Light LivingRoomLight = new Light("Living Room");
        Light KitchenLight = new Light("Kitchen");

        // 設置Command按鈕
        remoteControl.setOnCommand(0, new LightOnCommand(LivingRoomLight));
        remoteControl.setOffCommand(0, new LightOffCommand(LivingRoomLight));

        remoteControl.setOnCommand(1, new LightOnCommand(KitchenLight));
        remoteControl.setOffCommand(1, new LightOffCommand(KitchenLight));

        // 顯示有哪些功能
        System.out.println(remoteControl.toString());

        // 執行命令
        //// 客廳的
        remoteControl.pressOnButton(0);
        remoteControl.pressOffButton(0);
        //// 廚房的
        remoteControl.pressOnButton(1);
        remoteControl.pressOffButton(1);
    }
}

/**
 * 定義一個命令, 包含的執行execute的動作
 */
interface Command {
    void execute();
}

/**
 * 實作燈的開關命令
 */

class Light {
    String name; // 房間名稱

    Light(String name) {
        this.name = name;
    }

    void on() {
        System.out.println(name + ": Turn on the light");
    };
    void off() {
        System.out.println(name + ": Turn off the light");
    };
}

class LightOnCommand implements Command {
    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}


class LightOffCommand implements Command {
    Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

class NoCommand implements Command {
    NoCommand() {}

    public void execute() {
        System.out.println("Fuction not yet defined");
    }
}

/**
 * 定義遙控器類別
 */

class RemoteControl {
    Command[] onCommands = new Command[7];
    Command[] offCommands = new Command[7];

    // 初始化一開始的插槽, 若沒功能就定義一個沒作用的command供呼叫 (可避免用 if (command != null) 這種判斷方式
    RemoteControl() {
        for(int i=0; i<7; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setOnCommand(int slot, Command onCommand) {
        this.onCommands[slot] = onCommand;
    }

    public void setOffCommand(int slot, Command offCommand) {
        this.offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) {
        this.onCommands[slot].execute();
    }

    public void pressOffButton(int slot) {
        this.offCommands[slot].execute();
    }

    // 顯示我們塞了哪些功能到slot內
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();

        stringBuff.append("\n ------- Remote Control-------\n");
        for (int i=0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
        }

        return stringBuff.toString();
    }
}
