package com.example.zz.calculate;

import android.content.Intent;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zz on 17-5-12.
 */

public class FrameAdapter extends RecyclerView.Adapter<FrameAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private List<Frame> mFramesList;
    MainActivity context;
    Calculate calculate = new Calculate();
    BaseCalculate baseButton;
    ScienceCalculate scienceButton;


    static class ViewHolder extends RecyclerView.ViewHolder {
        View frameView;
        PercentRelativeLayout baseFrame;
        PercentRelativeLayout scienceFrame;

        public ViewHolder(View view) {
            super(view);
            frameView = view;
            baseFrame = (PercentRelativeLayout) view.findViewById(R.id.base_frame);
            scienceFrame = (PercentRelativeLayout) view.findViewById(R.id.science_frame);

        }

    }

    public FrameAdapter(MainActivity context, List<Frame> frameList) {
        this.context = context;
        mFramesList = frameList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_unit, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        baseButton = new BaseCalculate(view, this, this);
        scienceButton = new ScienceCalculate(view, this, this);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Frame frame = mFramesList.get(position);
        if (frame.getType() == frame.TYPE_BASE) {
            holder.baseFrame.setVisibility(View.VISIBLE);
            holder.scienceFrame.setVisibility(View.GONE);
        }
        if (frame.getType() == frame.TYPE_SCIENCE) {
            holder.baseFrame.setVisibility(View.GONE);
            holder.scienceFrame.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mFramesList.size();
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.button_0:
                    Click(baseButton.getButton0());
                    break;
                case R.id.button_1:
                    Click(baseButton.getButton1());
                    break;
                case R.id.button_2:
                    Click(baseButton.getButton2());
                    break;
                case R.id.button_3:
                    Click(baseButton.getButton3());
                    break;
                case R.id.button_4:
                    Click(baseButton.getButton4());
                    break;
                case R.id.button_5:
                    Click(baseButton.getButton5());
                    break;
                case R.id.button_6:
                    Click(baseButton.getButton6());
                    break;
                case R.id.button_7:
                    Click(baseButton.getButton7());
                    break;
                case R.id.button_8:
                    Click(baseButton.getButton8());
                    break;
                case R.id.button_9:
                    Click(baseButton.getButton9());
                    break;
                case R.id.button_add:
                    Click(baseButton.getButton_add());
                    break;
                case R.id.button_sub:
                    Click(baseButton.getButton_sub());
                    break;
                case R.id.button_mul:
                    Click(baseButton.getButton_mul());
                    break;
                case R.id.button_div:
                    Click(baseButton.getButton_div());
                    break;
                case R.id.button_dot:
                    Click(baseButton.getButton_dot());
                    break;

                case R.id.button_equal:
                    if (calculate.getCalculateData().length()!=0)
                    if (calculate.OnOff(baseButton.getButton_equal().getButtonType())) {
                        calculate.Calculate();
                        calculate.Equal();
                        context.addHistoryList(calculate.getTopShowData().toString(),calculate.getResult());
                        Show(baseButton.getButton_equal().getButtonType(),
                                calculate.getTopShowData().toString(),
                                calculate.getResult());
                    }
                    break;

                case R.id.button_clear:
                    if (calculate.OnOff(baseButton.getButton_clear().getButtonType())) {
                        switch (Calculate.count_ACTION_OPERATOR) {
                            case 0:
                                Log.d("Button_clear()", "in");
                                calculate.Remove();
                                Show(baseButton.getButton_clear().getButtonType(),
                                        calculate.getTopShowData().toString(),
                                        calculate.getBottomShowData().toString());
                                break;
                            case 1:
                                Log.d("Button_clear()", "in");
                                calculate.Clear();
                                Show(MyButton.ACTION_OPERATOR,
                                        calculate.getTopShowData().toString(),
                                        calculate.getBottomShowData().toString());
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                case R.id.button_sin:
                    Click(scienceButton.getButton_sin());
                    break;
                case R.id.button_cos:
                    Click(scienceButton.getButton_cos());
                    break;
                case R.id.button_tan:
                    Click(scienceButton.getButton_tan());
                    break;
                case R.id.button_log:
                    Click(scienceButton.getButton_log());
                    break;
                case R.id.button_ln:
                    Click(scienceButton.getButton_ln());
                    break;
                case R.id.button_fact:
                    Click(scienceButton.getButton_fact());
                    break;
                case R.id.button_sq:
                    Click(scienceButton.getButton_sq());
                    break;
                case R.id.button_sqr:
                    Click(scienceButton.getButton_sqr());
                    break;
                case R.id.button_percent:
                    Click(scienceButton.getButton_percent());
                    break;
                case R.id.button_PI:
                    Click(scienceButton.getButton_PI());
                    break;
                case R.id.button_e:
                    Click(scienceButton.getButton_e());
                    break;
                case R.id.button_ans:
                    scienceButton.getButton_ans().setShowData("Ans");
                    scienceButton.getButton_ans().setCalculateData(calculate.getResult());
                    Click(scienceButton.getButton_ans());
                    break;
                case R.id.button_bracket_left:
                    Click(scienceButton.getButton_bracket_left());
                    break;
                case R.id.button_bracket_right:
                    Click(scienceButton.getButton_bracket_right());
                    break;
                case R.id.button_shift:
                    Log.d("BUTTON", "Shift");
                    Click(scienceButton.getButton_shift());
                    break;
                case R.id.button_binary:
                    if (calculate.OnOff(scienceButton.getButton_binary().getButtonType())) {
                        calculate.Calculate();
                        calculate.Equal();
                        calculate.System(scienceButton.getButton_binary().getShowData());
                        Show(scienceButton.getButton_binary().getButtonType(),
                                calculate.getTopShowData().toString(),
                                calculate.getResult());
                    }
                    break;
                case R.id.button_octal:
                    if (calculate.OnOff(scienceButton.getButton_octal().getButtonType())) {
                        calculate.Calculate();
                        calculate.Equal();
                        calculate.System(scienceButton.getButton_octal().getShowData());
                        Show(scienceButton.getButton_binary().getButtonType(),
                                calculate.getTopShowData().toString(),
                                calculate.getResult());
                    }
                    break;
                case R.id.button_decimal:
                    if (calculate.OnOff(scienceButton.getButton_decimal().getButtonType())) {
                        calculate.Calculate();
                        calculate.Equal();
                        calculate.System(scienceButton.getButton_decimal().getShowData());
                        Show(scienceButton.getButton_binary().getButtonType(),
                                calculate.getTopShowData().toString(),
                                calculate.getResult());
                    }
                    break;
                case R.id.button_hexadecimal:
                    if (calculate.OnOff(scienceButton.getButton_hexadecimal().getButtonType())) {
                        calculate.Calculate();
                        calculate.Equal();
                        calculate.System(scienceButton.getButton_hexadecimal().getShowData());
                        Show(scienceButton.getButton_binary().getButtonType(),
                                calculate.getTopShowData().toString(),
                                calculate.getResult());
                    }
                    break;
                case R.id.button_history:
                    context.toHistory();
                    break;
                default:
                    break;
            }
        } catch (Calculate.SystemException e) {
            calculate.Clear();
            Show(MyButton.ACTION_OPERATOR, e.toString(), "");
        } catch (Exception e) {
            Show(MyButton.ACTION_OPERATOR, e.toString(), "");
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.button_clear:
                calculate.Clear();
                Show(MyButton.ACTION_OPERATOR,
                        calculate.getBottomShowData().toString(),
                        calculate.getCalculateData().toString());

                break;
            default:
                break;
        }
        return true;
    }

    public void Show(int type, String show, String calculate) {
        switch (type) {
            case MyButton.ACTION_OPERATOR:
                Log.d("bottomShowData", "SHow: " + calculate);
                context.textView.setText(calculate);
                Log.d("TopShowData", "SHow: " + show);
                context.textViewTop.setText(show);
                context.textViewTop.setGravity(Gravity.TOP);
                context.textViewTop.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
                context.textView.setGravity(Gravity.TOP);
                context.textView.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
                break;
            case MyButton.REMOVE:
                Log.d("bottomShowData", "SHow: " + calculate);
                context.textView.setText(calculate);
                Log.d("TopShowData", "SHow: " + show);
                context.textViewTop.setText(show);
                break;
            default:
                Log.d("Show", "Show: default show");
                context.textView.setText(show);
                context.ReFlashTextView();
                break;
        }
    }

    public void Click(MyButton tempButton) {
        Log.d("BUTTON", "in onClick ");

        if (calculate.OnOff(tempButton.getButtonType())) {

            calculate.appendData(tempButton.getShowData(),
                    tempButton.getCalculateData());

            Log.d("BUTTON", "onClick:calculate " + tempButton.getCalculateData());

            Show(tempButton.getButtonType(), calculate.getBottomShowData().toString(),
                    calculate.getCalculateData().toString());
        }
    }
}
