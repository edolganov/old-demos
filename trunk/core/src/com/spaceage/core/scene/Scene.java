package com.spaceage.core.scene;

import java.util.ArrayList;
import java.util.Timer;

import com.spaceage.core.scene.timer.SceneListener;
import com.spaceage.core.scene.timer.SceneTimerTask;
import com.spaceage.core.scene.timer.SceneUpdater;
import com.spaceage.util.ColorUtil;
import com.spaceage.util.Util;

public class Scene extends AbstractVisualObject implements SceneUpdater {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private Timer timer;
	private SceneListener updateSceneListener;
	
	public Scene() {
		width = Integer.MAX_VALUE;
		height = Integer.MAX_VALUE;
		timer = new Timer("scene-timer-"+Util.toObjectString(this), true);
	}
	
	
	public void add(Layer layer){
		layers.add(layer);
	}
	
	public void setUpdateSceneListener(SceneListener updateSceneListener) {
		this.updateSceneListener = updateSceneListener;
	}


	@Override
	public int getRGBA(int x, int y){
		
		int outColor = ColorUtil.WHITE_COLOR;
		
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			int layerColor = getLayerRGBA(i, x, y, layer);
			outColor = ColorUtil.mixColors(outColor, layerColor);
		}
		
		return outColor;
	}


	private int getLayerRGBA(int index, int globalX, int globalY, Layer layer) {
		return layer.getRGBA(globalX, globalY);
	}


	public void start(int delay, int period) {
		timer.schedule(new SceneTimerTask(this), delay, period);
	}
	
	public void stop(){
		timer.cancel();
	}


	public void nextStateReq() {
		if(updateSceneListener != null){
			updateSceneListener.onUpdateRequest(this);
		}
	}

	@Override
	public void updateScene() {
		for(int i=0; i < layers.size(); i++){
			Layer layer = layers.get(i);
			layer.updateState();
		}
	}
	
	

}
