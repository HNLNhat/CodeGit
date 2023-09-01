using Newtonsoft.Json;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using UnityEngine;
using UnityEngine.Networking;
using TMPro;

public class ForgotPassword : MonoBehaviour
{
    public TMP_InputField txtUser, txtOTP, txtNewPass, txtReNewPass;
    public GameObject resetPassword, sendOTP, login;
    // Start is called before the first frame update
    void Start()
    {
        
    }
    
    // Update is called once per frame
    void Update()
    {
        
    }
    public void SendOTP()
    {
        var user = txtUser.text;
        OTPModel oTPModel = new OTPModel(user);
        StartCoroutine(SendOTPAPI(oTPModel));
        SendOTPAPI(oTPModel);
    }
    //Gọi API send OTP
    IEnumerator SendOTPAPI(OTPModel oTPModel)
    {
        
        Debug.Log("API save position");
        string jsonStringRequest = JsonConvert.SerializeObject(oTPModel);

        var request = new UnityWebRequest("https://hoccungminh.dinhnt.com/fpt/send-otp", "POST");
        byte[] bodyRaw = Encoding.UTF8.GetBytes(jsonStringRequest);
        request.uploadHandler = new UploadHandlerRaw(bodyRaw);
        request.downloadHandler = new DownloadHandlerBuffer();
        request.SetRequestHeader("Content-Type", "application/json");
        yield return request.SendWebRequest();

        if (request.result != UnityWebRequest.Result.Success)
        {
            Debug.Log(request.error);
        }
        else
        {
            var jsonString = request.downloadHandler.text.ToString();
            ResponseModel responseModel = JsonConvert.DeserializeObject<ResponseModel>(jsonString);
            if(responseModel.status == 1)
            {
                //Thành công, load panel reset
                resetPassword.SetActive(true);
                sendOTP.SetActive(false);
            }
            else
            {
                //Hiện thông báo thất bại

            }

        }
        request.Dispose();
    }

   
   public void ResetPass()
    {
        var newPass = txtNewPass.text;
        var reNewPass = txtReNewPass.text;
        if (newPass.Equals(reNewPass))
        {
            var user = txtUser.text;
            int otp = int.Parse(txtOTP.text);
            ResetPassModel resetPassModel = new ResetPassModel(user, otp, newPass);
            Debug.Log(newPass);
            StartCoroutine(ResetPassAPI(resetPassModel));
            ResetPassAPI(resetPassModel);
        }
        else
        {

        }
  
    }

    //Gọi API Resetpass
    IEnumerator ResetPassAPI(ResetPassModel resetPassModel)
    {
        Debug.Log("Reset");
        string jsonStringRequest = JsonConvert.SerializeObject(resetPassModel);
        Debug.Log(jsonStringRequest);

        var request = new UnityWebRequest("https://hoccungminh.dinhnt.com/fpt/reset-password", "POST");
        byte[] bodyRaw = Encoding.UTF8.GetBytes(jsonStringRequest);
        request.uploadHandler = new UploadHandlerRaw(bodyRaw);
        request.downloadHandler = new DownloadHandlerBuffer();
        request.SetRequestHeader("Content-Type", "application/json");
        yield return request.SendWebRequest();

        if (request.result != UnityWebRequest.Result.Success)
        {
            Debug.Log(request.error);
        }
        else
        {
            var jsonString = request.downloadHandler.text.ToString();
            ResponseModel responseModel = JsonConvert.DeserializeObject<ResponseModel>(jsonString);

            if (responseModel.status == 1)
            {
                //Trở về login
               resetPassword.SetActive(false);
                login.SetActive(true);
            }
            else
            {             
                //Hiển thị thông báo
            }

        }
        request.Dispose();
    }
}
