        var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
        (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

	Sys.ie = isIE(); 

        if (Sys.ie) 
	{
		var obj = document.getElementById('obj_ie');
	}
        if (Sys.firefox || Sys.chrome)
	{
		var obj = document.getElementById('obj_firefox_chrome');
	}
        if (Sys.opera) 
	{
//		document.write('Opera: ' + Sys.opera);
	}
        if (Sys.safari) 
	{
		var obj = document.getElementById('obj_firefox_chrome');
//		document.write('Safari: ' + Sys.safari);
	}
//	var msg = document.getElementById('TxtArea');

	function isIE()
	{
		if(window.ActiveXObject || "ActiveXObject" in window)
		{
			return 1;
		}	
		else
		{
			return 0;
		}
	}
//连接读卡器
  function Connect()
{
	var iRet;
	try{
	if(isComOpen==false)         //如果读卡器的串口还没有打开
	{
	  var hdev=1;
	  iRet=obj.initialcom(100,115200);   //连接读写器，100为USB口， 115200为波特率
	  if(iRet != -1)
	  {
		
		icdev=iRet;
		var ncard=0;
		var data ="";

//		hdev=obj.beep(icdev,10);   //使读写器设备蜂鸣
		//iRet=obj.request(icdev,0);
		//ncard=obj.anticoll(icdev,0);
		//msg.value =msg.value+iRet+"\n"+ncard+"\n";
		//iRet=obj.select(icdev,ncard);
		//msg.value =msg.value+iRet+"\n";
		//ncard=obj.findcard(iRet,1);

		//hdev=obj.loadkey(iRet,0,gl_sector,"ffffffffffff"); 
		//hdev=obj.authentication(iRet,0,gl_sector);
		//if(hdev!=0)alert("error");
		//hdev=obj.read(iRet,0,gl_BinBlock);
                
		//var chstr="";
	        var hex="";
                //hex=obj.charToHex(chstr,4);
                //if(chstr!="0123")msg.value="ERROR\n";
		//msg.value =msg.value+hex+"\n";
		//chstr = obj.hexTochar(hex,2);

//		msg.value =msg.value+hex+"\n"+"连接读卡器成功！\n";
		//msg.value=msg.value+hdev+"\n";
         	isComOpen=true;             //读卡器设为打开状态
         	return true;
	  }
	  else
	  {
//		msg.value = "读卡器连接失败\n";
                isComOpen=false;           //读卡器设为未打开状态
                return false;
	  }
	}
	}catch(e){alert(e.message);}

	return;
}

//装载密码
function LoadKey()
{
	var iRet;
	var  data;

	iRet = obj.loadkey(icdev,0,gl_sector,"FFFFFFFFFFFf");      //装载密码,0为装载密码A，2为扇区，ffffffffffff为密码

	if(iRet)
	{
//		msg.value = msg.value + "装载密码失败！\n";
	}
	else
	{
//		msg.value = msg.value + "装载密码成功\n";
	}
	
	return;

}

// 寻卡
function Findcard()
{
     var strcard="";
     strcard = obj.findcardStr(icdev,1);      //1为读多张卡模式
	if(strcard!="")
	{
		//msg.value = msg.value + "寻卡成功\n";
		hasCard =true;
		//if(nRead<1)    //第一次读卡号
		//{
//                  msg.value=msg.value+"卡号为："+strcard+"\n";
		//}
		obj.beep(icdev,100);   //使读写器设备蜂鸣
		
		return strcard;
	}
	else
	{
//		msg.value = msg.value + "寻卡失败\n";
		hasCard =false;        //设置为当前无卡状态
		return "";
	}

}
//读卡
function Read()
{
	var iRet;
	var  data=" ";

	if(icdev==0)
	{
	  msg.value=msg.value+"ERROR";
	  return;
	}
	var strcard="";

	//hdev=obj.loadkey(icdev,0,gl_sector,"ffffffffffff");
	strcard=obj.findcardStr(icdev,1);//多卡模式(1)寻卡
	
	iRet = obj.authentication(icdev,0,gl_sector);    //认证密码      0为模式，2为第2扇区
	if(iRet)
	{
		msg.value = msg.value + "密码校验失败\n";
	}
	else
	{
		msg.value = msg.value + "密码校验成功\n";
	}

	data =obj.read(icdev,gl_BinBlock);        //8为读第八块的数据
	//data =obj.directRead(icdev,gl_BinBlock);        //直接读块中数据，可能不可见
	
	if(data != "")
	{
		msg.value = msg.value + "读卡成功！数据为：\n" + data + "\n";
		
	}
	else
	{
		msg.value = msg.value + "读卡失败\n";
	}
}


//写卡
function Write()
{
        var strcard="";
	var  data=" ";
        var  iRet=0;
	
	strcard=obj.findcardStr(icdev,1);//多卡模式(1)寻卡
	if(strcard!="")
	{
		msg.value = msg.value + "寻卡成功\n";
	}
	else
	{
		msg.value = msg.value + "录卡失败\n"+iRet;
	}
	
	 iRet = obj.authentication(icdev,0,gl_sector);//验证第2扇区        0为模式，2为第2扇区
	if(iRet)
	{
		msg.value = msg.value + "密码校验失败\n";
	}
	else
	{
		msg.value = msg.value + "密码校验成功\n";
	}
	
	iRet = obj.write(icdev,gl_BinBlock,"11111111111111111111111111111111");   //8为写第八块的数据
	//iRet = obj.directWrite(icdev,gl_BinBlock,"深圳峰华科技公司");//直接写数据，汉字为8个，纯字符串为16个
	if(iRet == 0)
	{
		msg.value = msg.value + "写卡成功\n";
	}
	else
	{
		msg.value = msg.value + "写卡失败\n";
	}
		
	return;

}


//断开连接
function Disconnect()
{
	var iRet;
	var  data;
	iRet = obj.exit(icdev);
	if(iRet)
	{
		msg.value = msg.value + "断开连接失败\n";
	}
	else
	{
		msg.value = msg.value + "成功断开连接\n";

         	isComOpen=false; //设置串口为关闭状态
	}

}

//循环设置当前卡的状态
function SetCardStatue()
{
     Findcard();
   //   if(hasCard==true&&nRead<1)   //每张卡限制仅读卡号一次
   // 	 Read();
}

//值操作
function ValOper()
{
 
    var iRet=1;
    var value=1000;
	strcard=obj.findcardStr(icdev,1);//多卡模式(1)寻卡
	if(strcard!="")
	{
		msg.value = msg.value + "寻卡成功\n";
	}
	else
	{
		msg.value = msg.value + "录卡失败\n"+iRet;
	}
	
	 iRet = obj.authentication(icdev,0,gl_sector);//验证第2扇区        0为模式，2为第2扇区
	if(iRet)
	{
		msg.value = msg.value + "密码校验失败\n";
	}
	else
	{
		msg.value = msg.value + "密码校验成功\n";
	}
    iRet=obj.initialval(icdev,gl_valBlock,value);
    iRet=obj.increment(icdev,gl_valBlock,10);
    iRet=obj.transfer(icdev,gl_valBlock);
    iRet=obj.decrement(icdev,gl_valBlock,10);
    iRet=obj.transfer(icdev,gl_valBlock);

    if(iRet)
    {
     msg.value=msg.value+"值操作失败！\n";
    }
    else
    {
     msg.value=msg.value+"值操作成功！\n";
    }

  
   iRet=obj.readval(icdev,9);

   msg.value=msg.value+"值为 "+iRet+"\n";
}

function Changekey()
{
	var iRet;
	var strcard="";
	try{
	
	strcard=obj.findcardStr(icdev,1);	
	iRet=obj.authentication(icdev,0,gl_sector);
        iRet=obj.changkey(icdev,gl_sector,"FFFFFFFFFFFf","FF078069",0,"FFFFFFFFFFFF");//修改第2扇区密码为FFFFFFFFFFFF
	iRet=obj.halt(icdev); //修改密码后要调用此函数，使修改生效
        if(iRet)
        {
          msg.value=msg.value+"改密码失败！\n";
        }
        else
        {
          msg.value=msg.value+"改密码成功！\n";
        }
	}catch(e){alert(e.message);}
}
function Fcputest()
{

   try{
	Disconnect();
	window.location.href='FM1208_Test.html';

    }catch(e){alert(e.message);}
    return;
}

function MifareProtest()
{
   var iRet;
   var ncard=0;
   var data="";
   var scmd="0084000008";//选择DF
   try{

	Findcard();

        data=obj.mifareproReset(icdev);
	if(data != "")
	{
	   msg.value = msg.value + "卡片复位成功！复位信息为：\n" + data + "\n";
	}
	else
	{
	   msg.value = msg.value + "卡片复位失败\n";
	}

	
        data=obj.mifareproCommandlink(icdev,scmd);
        if(data != "")
      	{
	  msg.value = msg.value + "命令成功！返回信息为：\n" + data + "\n";
	}
	else
	{
	  msg.value = msg.value + "命令失败\n";
	}

    }catch(e){alert(e.message);}
    return;
}

function IDCardtest()
{
	var iRet;

	if(icdev==0)
	{
	  msg.value=msg.value+"ERROR";
	  return;
	}
	var strcard="";
	strcard = obj.GetIDCardSN(icdev);

	if(strcard != "")
	{
		msg.value = msg.value + "读卡成功！数据为：\n" + strcard + "\n";
	}
	else
	{
		msg.value = msg.value + "读卡失败\n";
	}
	return;
}
 var nRead =0;     //同一张卡循环读的次数
 var hasCard =false;
 var isComOpen=false;
 var icdev=0;
 var gl_sector = 2;
 var gl_BinBlock = 8;
 var gl_valBlock = 9;