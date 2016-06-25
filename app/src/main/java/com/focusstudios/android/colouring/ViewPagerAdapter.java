package com.focusstudios.android.colouring;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {
	Context context;
	String[] text;
	int[] image;
	LayoutInflater inflater;

	public ViewPagerAdapter(Context context, String[] text, int[] image) {
		this.context = context;
		this.text = text;
		this.image = image;
	}

	@Override
	public int getCount() {
		return text.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == (object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		TextView Text;
		ImageView Image;
		Typeface font = Typeface.createFromAsset(context.getAssets(), "Optien.ttf");

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.tutorial_item, container,
				false);

		Text = (TextView) itemView.findViewById(R.id.string);
		Text.setText(text[position]);
		Text.setTypeface(font);

		Image = (ImageView) itemView.findViewById(R.id.image);
		Image.setAdjustViewBounds(true);
		if(position != 0) {
			Image.setImageResource(image[position]);
		}

		(container).addView(itemView);
		return itemView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		(container).removeView((RelativeLayout) object);

	}
}