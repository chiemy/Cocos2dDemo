package com.chiemy.cocos2ddemo;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrameCache;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;

public class MainActivity extends Activity {
	private CCGLSurfaceView ccglSurfaceView;
	private CCScene myScene;
	private float height;
	private float width;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ccglSurfaceView = new CCGLSurfaceView(this);
		setContentView(ccglSurfaceView);
		CCDirector.sharedDirector().attachInView(ccglSurfaceView);
		//CCDirector.sharedDirector().setDisplayFPS(true);
		//设置显示方向，横向，纵向
		//CCDirector.sharedDirector().setDeviceOrientation(CCDirector.)
		CCDirector.sharedDirector().setAnimationInterval(1.0/30);
		height = CCDirector.sharedDirector().winSize().height;
		width = CCDirector.sharedDirector().winSize().width;
		
		//准备场景
		myScene = CCScene.node();
		myScene.addChild(new MyBgLayer());
		
		CCDirector.sharedDirector().runWithScene(myScene);
	}
	//场景
	private class MyScene extends CCScene{
		public MyScene(){
			super();
			//场景添加层
			//addChild(new MyThirdLayer());
			//addChild(new MyLayer());
			addChild(new MyBgLayer());
		}
		
	}
	//层
	private class MyLayer extends CCLayer{
		CCLabel label;
		public MyLayer(){
			super();
			label = CCLabel.makeLabel("测试","A Damn Mess.ttf", 40);
			//设置锚点，setAnchorPoint();
			//设置坐标，默认锚点为中心位置,屏幕左下角为0，0点
			label.setPosition(CGPoint.make(240, 400));
			//设置颜色
			label.setColor(ccColor3B.ccc3(0,0,0));
			this.addChild(label);
		}
		@Override
		public void onExit() {
			label.cleanup();
			super.onExit();
		}
	}
	private class MyBgLayer extends CCLayer{
		public MyBgLayer(){
			//精灵
			CCSprite bg = CCSprite.sprite("background.png");
			//bg.setPosition(CGPoint.make(200, 300));
			bg.setAnchorPoint(0,0);
			CCSpriteFrameCache.sharedSpriteFrameCache().addSpriteFrames("ui_main.plist");
			//根据描述文件的图名，得到精灵帧（参数部分）
			//根据精灵帧得到精灵图片
			//顶端标题栏
			CCSprite top_bar = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("top_bar.png"));
			top_bar.setAnchorPoint(0,1);
			top_bar.setPosition(CGPoint.make(0, height));
			top_bar.setScaleY(height*0.1F/top_bar.getBoundingBox().size.height);
			//旗帜
			CCSprite flag = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("flag.png"));
			flag.setAnchorPoint(0.5f,1);
			flag.setPosition(CGPoint.make(width/2, height-5));
			flag.setScaleY(height*0.3F/flag.getBoundingBox().size.height);
			flag.setScaleX(width*0.3f/flag.getBoundingBox().size.width);
			//level后红色背景的背景
			CCSprite base01 = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("base01.png"));
			base01.setPosition(CGPoint.make(width/5,height*4/5));
			base01.setScaleY(height*0.13F/base01.getBoundingBox().size.height);
			base01.setScaleX(width*0.25F/base01.getBoundingBox().size.width);
			//level后的红色背景
			CCSprite level = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("level.png"));
			level.setPosition(CGPoint.make(width/5,height*4/5));
			level.setScaleY(height*0.1F/level.getBoundingBox().size.height);
			level.setScaleX(width*0.15F/level.getBoundingBox().size.width);
			
			CCSprite base02 = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("base01.png"));
			base02.setPosition(CGPoint.make(width*4/5,height*4/5));
			base02.setScaleY(height*0.13F/base02.getBoundingBox().size.height);
			base02.setScaleX(width*0.25F/base02.getBoundingBox().size.width);
			
			//游戏信息按钮
			CCSprite info = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("button_Info01.png"));
			info.setPosition(CGPoint.make(width*4/5,height*4/5));
			info.setScaleY(height*0.12F/info.getBoundingBox().size.height);
			info.setScaleX(width*0.25F/info.getBoundingBox().size.width);
			//开始按钮背景
			CCSprite base03 = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("base02.png"));
			base03.setPosition(CGPoint.make(width/2,height/2));
			base03.setScaleY(height*0.3F/base03.getBoundingBox().size.height);
			base03.setScaleX(width*0.9F/base03.getBoundingBox().size.width);
			//开始按钮
			CCSprite button_play01 = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("button_play01.png"));
			button_play01.setPosition(CGPoint.make(width/2,height/2));
			button_play01.setScaleY(height*0.3F/button_play01.getBoundingBox().size.height);
			button_play01.setScaleX(width*0.6F/button_play01.getBoundingBox().size.width);
			
			
			//关注微信，微信背景，微信按钮的基点
			CGPoint point = CGPoint.make(width*0.5f/10,height/4);
			//Text01,关注加50
			CCSprite attentionWechat = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("Text01.png"));
			attentionWechat.setAnchorPoint(0,0);
			attentionWechat.setPosition(point);
			attentionWechat.setScaleX(width*0.2f/attentionWechat.getBoundingBox().size.width);
			
			//微信背景
			CCSprite wechatBase = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("base08.png"));
			wechatBase.setAnchorPoint(0,1);
			wechatBase.setPosition(point);
			wechatBase.setScaleY(height*0.12F/wechatBase.getBoundingBox().size.height);
			wechatBase.setScaleX(width*0.9F/wechatBase.getBoundingBox().size.width);
			//微信按钮
			CCSprite wechatButton = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("button_Wechat01.png"));
			wechatButton.setAnchorPoint(0,1);
			wechatButton.setPosition(point);
			wechatButton.setScaleY(height*0.12F/wechatButton.getBoundingBox().size.height);
			wechatButton.setScaleX(width*0.3f/wechatButton.getBoundingBox().size.width);
			//官方微信
			CCSprite wechatOffical = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("Text_officalwechat.png"));
			wechatOffical.setAnchorPoint(0,1);
			wechatOffical.setPosition(CGPoint.make(width*3/10,height/4 - 10));
			wechatOffical.setScaleX(width*0.2f/wechatOffical.getBoundingBox().size.width);
			//Text04.png,制作人员
			//Text09.png猜图
			CCSprite guessText = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("Text_cg.png"));
			guessText.setAnchorPoint(0,1);
			guessText.setPosition(CGPoint.make(width*3/10,height/4 - 50));
			guessText.setScaleX(width*0.1f/guessText.getBoundingBox().size.width);
			
			//bottom_bar.png底部
			CCSprite bottom_bar = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("bottom_bar.png"));
			bottom_bar.setAnchorPoint(0,0);
			bottom_bar.setPosition(CGPoint.make(0,0));
			bottom_bar.setScaleY(height*0.06F/bottom_bar.getBoundingBox().size.height);
			
			//medal.png奖章
			CCSprite medal = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("medal.png"));
			medal.setAnchorPoint(0.5f,0);
			medal.setPosition(CGPoint.make(width/2,0));
			medal.setScaleY(height*0.06F/medal.getBoundingBox().size.height);
			//层添加精灵
			this.addChild(bg);
			this.addChild(top_bar);
			this.addChild(flag);
			this.addChild(base01);
			this.addChild(base02);
			this.addChild(level);
			this.addChild(info);
			this.addChild(base03);
			this.addChild(button_play01);
			this.addChild(attentionWechat);
			this.addChild(wechatBase);
			this.addChild(wechatButton);
			this.addChild(wechatOffical);
			this.addChild(guessText);
			this.addChild(bottom_bar);
			this.addChild(medal);
		}
		@Override
		public void onExit() {
			// TODO Auto-generated method stub
			
			super.onExit();
		}
	}
	//颜色层
	private class MyThirdLayer extends CCColorLayer{

		protected MyThirdLayer() {
			super(ccColor4B.ccc4(255, 255, 255, 255));
			//将plist文件加载进来
			CCSpriteFrameCache.sharedSpriteFrameCache().addSpriteFrames("ui_main.plist");
			//根据描述文件的图名，得到精灵帧（参数部分）
			//根据精灵帧得到精灵图片
			CCSprite author = CCSprite.sprite(CCSpriteFrameCache.sharedSpriteFrameCache().spriteFrameByName("Button_about_author01.png"));
			author.setScale(0.5f);
			author.setPosition(CGPoint.make(240, 200));
			
			addChild(author);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
