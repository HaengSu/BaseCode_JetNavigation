package com.app.basecode_jetnavigation

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window

open class BaseDialog(val mContext: Context) {

    var dlg = Dialog(mContext)

    open fun showDialog(type : Int) {
        dlg.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            show()
        }
    }
}