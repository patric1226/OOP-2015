package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.Model;

import com.game.src.main.controls.Controller;
import com.game.src.main.sprite.GameObject;
import com.game.src.main.sprite.Textures;

public class Bullet extends GameObject implements Model {

	private double BulletSpeed = 8;
	private Game game;
	Controller controller;

	private Textures tex;

	public Bullet(double x, double y, Textures tex, Game game, Controller controller) {
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.controller = controller;

	}

	public void tick() {
		y -= BulletSpeed;

		// if(Physics.Collision(this, (EntityB) game.eb )){
		// System.out.println("collision detected");
		// }
	}

	public void render(Graphics g) {
		g.drawImage(tex.missile, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

}
