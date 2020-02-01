# BX-6Q DYNAMIC AREA JAVA SDK ![Java CI](https://github.com/onbonlab/bx.dual.dyn.java/workflows/Java%20CI/badge.svg)

BX-6Q1/6Q2/6Q3 的动态区 JAVA API。

## MAVEN 引用
可以通过 MAVEN 来引用此 Package，方法如下：
https://github.com/onbonlab/bx.dual.dyn.java/packages/118223

## 支持的功能
* 删除动态区
* 更新动态区（单个）
## 调用方法
此 API 接口的调用方式如下：

**步骤1：**

创建 BxReq 对象

BxReq req = new ...

**步骤2：**

使用 BxReq 对象的 pack() 接口生成命令的字节流

**步骤3：**

使用 TCP/UDP 或串口发送命令序列

**步骤4:**

读取控制器的返回值

**步骤5：**

使用 BxResp.parse() 接口对返回序列进行解析

## 使用例程

```java
//
// 创建 Socket
Socket client = new Socket();

//
// 创建 socket 地址
SocketAddress address = new InetSocketAddress("192.168.31.188", 5005);

try {
	//
	// 建立 TCP 连接
	client.connect(address, 3000);
	//
	// 设置读超时时间
	client.setSoTimeout(3000);

	//
	// 创建输出流
	OutputStream out = client.getOutputStream();

	//
	// 创建输入流
	InputStream in = client.getInputStream();

	// 从文件中读取两张图片
	BufferedImage img1, img2;
	try {
		img1 = ImageIO.read(new File("e:\\p1.png"));
		img2 = ImageIO.read(new File("e:\\p2.png"));
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}

	// 创建 动态区对象
	BxAreaDynamic area = new BxAreaDynamic(0, 64, 0, 64, 64);
	// 将本动态区与 节目0 绑定
	area.attachToProgram(0);
	area.setAttachToAllPro(false);

	// 创建两个 Page
	BxPageBmp p1 = new BxPageBmp(img1);
	BxPageBmp p2 = new BxPageBmp(img2);
	area.addPage(p1);
	area.addPage(p2);

	// 创建更新动态区命令
	BxReq req = new BxReqSendDynArea(area);

	// 生成命令序列
	byte [] seq = req.pack();
	BxDebugFileWriter.writeToFile(seq, "d:\\data.txt");
	// 发送命令
	out.write(seq);

	//
	// 回读返回帧
	byte[] rdata = new byte[1024];
	int len = in.read(rdata);

	// 对返回的 response 进行解析
	BxResp resp = BxResp.parse(rdata, len);
	if(resp.isAck()) {
		System.out.println("ACK");
	}
	else {
		System.out.println("NACK");
	}

	//
	// 以下为删除动态区的流程
	// 创建一个 list，其中包含要删除的动态区 id
	List<Byte> areas = new ArrayList<Byte>();
	areas.add((byte)0x00);
	// 创建删除区域命令
	req = new BxReqDelDynAreas(areas);
	seq = req.pack();
	out.write(seq);

	//
	// 回读返回帧
	rdata = new byte[1024];
	len = in.read(rdata);

	// 对返回的 response 进行解析
	resp = BxResp.parse(rdata, len);
	if(resp.isAck()) {
		System.out.println("ACK");
	}
	else {
		System.out.println("NACK");
	}

	//
	out.close();
	in.close();
	client.close();

} catch (IOException e) {
	e.printStackTrace();
}
```

