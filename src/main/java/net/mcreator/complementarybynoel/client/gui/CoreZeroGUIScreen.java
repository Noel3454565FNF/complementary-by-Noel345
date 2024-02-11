
package net.mcreator.complementarybynoel.client.gui;

public class CoreZeroGUIScreen extends AbstractContainerScreen<CoreZeroGUIMenu> {

	private final static HashMap<String, Object> guistate = CoreZeroGUIMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_detonation;

	public CoreZeroGUIScreen(CoreZeroGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 276;
		this.imageHeight = 266;
	}

	private static final ResourceLocation texture = new ResourceLocation("complementary_by_noel345:textures/screens/core_zero_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);

	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

		button_detonation = new Button(this.leftPos + 101, this.topPos + 102, 77, 20, new TranslatableComponent("gui.complementary_by_noel345.core_zero_gui.button_detonation"), e -> {
		});

		guistate.put("button:button_detonation", button_detonation);
		this.addRenderableWidget(button_detonation);

	}

}
