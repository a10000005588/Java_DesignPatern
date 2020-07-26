# 命令模式 Command Pattern

命令模式主要將執行的命令, 與執行者做鬆綁的動作

## 沒有命令模式會是怎樣的寫法？？

假如我們現在要寫一個 遙控器 RemoteControl (執行者), 上面會有很多按鈕功能 (命令)

每個按鈕可能都對應各個功能, 例如 打開, 關閉某些房間的燈

於是我們定義了 `Light` 抽象類別, 有著 `on()`與`off()`開關燈的方法, 並且實作了 `LivingRoomLight`, `KitchenLight`這兩個房間並繼承 `Light`抽象類別的方法, 使他們都有開關的功能！

接著在遙控器 `RemoteControl`類別內定義了 `Light[]` 陣列, 儲存欲執行的功能 (實作Light的類別們)

```java=
public class main {
    public static void main(String[] args) {
        // 定義出一個遙控器instance
        RemoteControl remoteControl =
                new RemoteControl(
                new Light[]{
                        new LivingRoomLight(),
                        new KitchenLight()
                });
        // 0: 打開LivingRoom Light
        // 1: 打開Kitchen Light
        remoteControl.turnOnLight(0);
        remoteControl.turnOnLight(1);
        // 0: 關閉LivingRoom Light
        // 1: 關閉Kitchen Light
        remoteControl.turnOffLight(0);
        remoteControl.turnOffLight(1);
    }
}

class RemoteControl {

    Light[] lights = new Light[10];
    RemoteControl(Light[] lights) {
        // 將傳進來的lights放入到lights內
        for(int i=0; i<lights.length; i++) {
            this.lights[i] = lights[i];
        }
    }

    public void turnOnLight(int buttonNumber) {
        this.lights[buttonNumber].on();
    }

    public void turnOffLight(int buttonNumber) {
        this.lights[buttonNumber].off();
    }
}

abstract class Light {
    Light() {}

    abstract void on();
    abstract void off();
}

class LivingRoomLight extends Light {
    LivingRoomLight() {}

    @Override
    public void on() {
        System.out.println("Turn on the living room light");
    }

    @Override
    public void off() {
        System.out.println("Turn off the living room light");
    }
}

class KitchenLight extends Light {
    KitchenLight() {}

    @Override
    public void on() {
        System.out.println("Turn on the kitchen light");
    }

    @Override
    public void off() {
        System.out.println("Turn off the kitchem light");
    }
}
```

執行結果如下

![](https://i.imgur.com/AvxerGU.png)

### 問題

假如現在又想要添加電視與冷氣開關的功能 `TV`, `AirConditioner`, 那不就又要在`RemoteControl`類別內進行修改

```java=
class RemoteControl {
    // 又新增了HomeDevice陣列...定義家具集合的類別
    HomeDevice[] homeDevices = new HomeDevice[10];

    Light[] lights = new Light[10];
    RemoteControl(Light[] lights) {
        // 將傳進來的lights放入到lights內
        for(int i=0; i<lights.length; i++) {
            this.lights[i] = lights[i];
        }
    }

    public void turnOnLight(int buttonNumber) {
        this.lights[buttonNumber].on();
    }

    public void turnOffLight(int buttonNumber) {
        this.lights[buttonNumber].off();
    }
    
    // 又在定義HomeDevice的開關功能...
}

```

可看到每次若要為遙控器類別新增功能, 都要對`RemoteControl`進行修改的動作, 如此一來可能會造成其他已經內嵌好的功能可能被改壞的狀況發生, 這時我們可以使用 `Command 模式` 來避免這種狀況發生


## Command 命令模式的優勢

命令模式可以幫我們把要賦予`RemoteControl`的這些功能給封裝起來, 成為一個獨立的個體, 不會跟`RemoteControl`給耦合再一起 (像上面turnOnLight, turnOffLight等功能)


我們可以把 `Light` 的開關功能都視作為 `Command (命令)`抽象介面, 該介面包含了一個 `execute()`功能, 

接著由Command (命令)衍伸出 `LightOnCommand`與`LightOffCommand`這兩個實作類別, 負責定義`Light`的開與關的動作

![](https://i.imgur.com/t1zF1vQ.jpg)

```java=

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
    void on() {
        System.out.println("Turn on the light");
    };
    void off() {
        System.out.println("Turn off the light");
    };
}

class LightOnCommand implements Command {
    Light light;

    LightOnCommand() {
        this.light = new Light();
    }

    public void execute() {
        light.on();
    }
}


class LightOffCommand implements Command {
    Light light;

    LightOffCommand() {
        this.light = new Light();
    }

    public void execute() {
        light.off();
    }
}

class NoCommand implements Command {
    NoCommand() {}
    
    public void execute() {
        System.out.println("Not yet defined");
    }
}
```

接著我們需要在遙控器類別 `RemoteControl` 定義可放置Command的動作 `setXXXCommand()`, 以及呼叫Command的 `pressOnButton()`與`pressOffButton()`

```java=
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


```

透過這樣的做法, 我們可以看到原本`RemoteControl`內的與Light操作有關的動作, 都被我們透過 `Command` 抽象介面以及其 `LightOnCommand`與`LightOffCommand`實作類別給抽離出來了

於是我們可以來執行看看

```java=
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

```

![](https://i.imgur.com/q9PTG18.png)

若接下來需要新增如浴室開關, 電視開關, 只要透過`RemoteConrol`的`setCommand()`方法, 即可以動態做設置, 不需更動到遙控器類別原本的程式碼！ (除非要改變遙控器的slot大小了)

## 進階的Command Pattern技巧

等待補充 (為Command介面新增 undo()方法, 使動作復原)

## 應用場景

運用在任務序列中, 多執行緒只要拿到Command物件, 並且執行`execute`方法負責執行完就好

或是用在日誌管理, 將執行過的動作給記錄起來, 並且若後續伺服器當機, 可將命令給復原


