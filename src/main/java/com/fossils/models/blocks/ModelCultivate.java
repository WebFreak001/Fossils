package com.fossils.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCultivate extends ModelBase
{
    public ModelRenderer[] shapes = new ModelRenderer[10];

    public ModelCultivate()
    {
        textureWidth = 64;
        textureHeight = 64;

        shapes[0] = new ModelRenderer(this, 0, 0);
        shapes[0].addBox(0F, 0F, 0F, 16, 6, 16);
        shapes[0].setRotationPoint(-8F, 18F, -8F);
        shapes[1] = new ModelRenderer(this, 0, 22);
        shapes[1].addBox(-2F, 0F, 1F, 14, 25, 0);
        shapes[1].setRotationPoint(-5F, -7F, 6F);
        shapes[2] = new ModelRenderer(this, 0, 22);
        shapes[2].addBox(0F, 0F, 1F, 14, 25, 0);
        shapes[2].setRotationPoint(6F, -7F, 7F);
        shapes[3] = new ModelRenderer(this, 0, 22);
        shapes[3].addBox(0F, 0F, 0F, 14, 25, 0);
        shapes[3].setRotationPoint(7F, -7F, -7F);
        shapes[4] = new ModelRenderer(this, 0, 22);
        shapes[4].addBox(0F, 0F, 0F, 14, 25, 0);
        shapes[4].setRotationPoint(-7F, -7F, -7F);
        shapes[5] = new ModelRenderer(this, 28, 21);
        shapes[5].addBox(0F, 0F, 0F, 1, 25, 1);
        shapes[5].setRotationPoint(7F, -7F, -8F);
        shapes[6] = new ModelRenderer(this, 28, 21);
        shapes[6].addBox(0F, 0F, 0F, 1, 25, 1);
        shapes[6].setRotationPoint(-8F, -7F, -8F);
        shapes[7] = new ModelRenderer(this, 28, 21);
        shapes[7].addBox(0F, 0F, 0F, 1, 25, 1);
        shapes[7].setRotationPoint(7F, -7F, 7F);
        shapes[8] = new ModelRenderer(this, 28, 21);
        shapes[8].addBox(0F, 0F, 0F, 1, 25, 1);
        shapes[8].setRotationPoint(-8F, -7F, 7F);
        shapes[9] = new ModelRenderer(this, 0, 0);
        shapes[9].addBox(0F, 0F, 0F, 16, 1, 16);
        shapes[9].setRotationPoint(-8F, -8F, -8F);

        for (ModelRenderer shape : shapes)
        {
            shape.setTextureSize(64, 64);
        }
    }

    public void render()
    {
        for (ModelRenderer shape : shapes)
        {
            shape.render(0.0625f);
        }
    }
}
