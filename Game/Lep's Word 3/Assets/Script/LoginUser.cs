using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using UnityEngine.SceneManagement;
using TMPro;
using UnityEngine.UI;
using UnityEngine.EventSystems;
using System.Text;
using UnityEngine.Networking;
using Newtonsoft.Json;

public class LoginUser : MonoBehaviour
{
    public TMP_InputField edtUser, edtPass;
    public TMP_InputField edtEmail, edtPassword;
    public TMP_Text txtError;
    public Selectable first;
    private EventSystem eventSystem;
    public Button btnLogin;
    public static LoginResponse loginResponse;

    // Start is called before the first frame update
    void Start()
    {
        eventSystem = EventSystem.current;
        first.Select();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.Return))
        {
            btnLogin.onClick.Invoke();
        }
        if (Input.GetKeyDown(KeyCode.Tab))
        {
            Selectable next = eventSystem
                .currentSelectedGameObject
                .GetComponent<Selectable>()
                .FindSelectableOnDown();
            if (next != null) next.Select();
        }
        if (Input.GetKey(KeyCode.LeftShift))
        {
            Selectable next = eventSystem
               .currentSelectedGameObject
               .GetComponent<Selectable>()
               .FindSelectableOnUp();
            if (next != null) next.Select();
        }
    }
    public void CheckLogin()
    {
       
        StartCoroutine(Login());
        
        Login();

   }

    IEnumerator Login()
    {
        var user = edtUser.text;
        var pass = edtPass.text;
        UserModel userModel = new UserModel(user, pass);

        string jsonStringRequest = JsonConvert.SerializeObject(userModel);
        var request = new UnityWebRequest("https://hoccungminh.dinhnt.com/fpt/login", "POST");
        byte[] bodyRaw = Encoding.UTF8.GetBytes(jsonStringRequest);
        request.uploadHandler = new UploadHandlerRaw(bodyRaw);
        request.downloadHandler = new DownloadHandlerBuffer();
        request.SetRequestHeader("Content-Type", "application/json");
        yield return request.SendWebRequest();

        if (request.result != UnityWebRequest.Result.Success)
        {
            Debug.Log("====>");
            Debug.Log(request.error);
        }
        else
        {
            Debug.Log("<====");
            var jsonString = request.downloadHandler.text.ToString();
            Debug.Log(jsonString);
            loginResponse = JsonConvert.DeserializeObject<LoginResponse>(jsonString);
            if (loginResponse.status == 1)
            {
                SceneManager.LoadScene(1);

            }
            else
            {
                txtError.text = loginResponse.notification;
            }
        }
    }
    public void CheckRegister()
    {

        StartCoroutine(Register());

        Register();

    }
    IEnumerator Register()
    {
        var email = edtEmail.text;
        var password = edtPassword.text;
   

        UserModel userModel = new UserModel(email, password);

        string jsonStringRequest = JsonConvert.SerializeObject(userModel);


        var request = new UnityWebRequest("https://hoccungminh.dinhnt.com/fpt/register", "POST");
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
            RegisterReponse registerReponse = JsonConvert.DeserializeObject<RegisterReponse>(jsonString);
            if (registerReponse.status == 1)
            {
                
            }
            else
            {
                txtError.text = registerReponse.notification;
            }
        }
    }
}
